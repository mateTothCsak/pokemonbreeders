package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.dto.*;
import net.tcsm.pokemonbreeders.util.BreedingPathSearcher;
import net.tcsm.pokemonbreeders.util.BreedingPathUtils;
import net.tcsm.pokemonbreeders.util.EggGroupConnector;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main service of the project.
 * Responsible for providing data for PokemonController
 */
@Service
public class PokemonService {

    private final PokemonEggGroupsService eggGroupsService;
    private final PokemonSpeciesNamesSerivce speciesNamesService;
    private final EggGroupConnector connector;
    private final BreedingPathUtils breedingPathUtils;
    private final PokemonDataService dataService;
    private final EggGroupProseSerivce eggGroupProseSerivce;

    public PokemonService(PokemonEggGroupsService eggGroupsService, PokemonSpeciesNamesSerivce speciesNamesService,
                          EggGroupConnector connector, BreedingPathUtils breedingPathUtils, PokemonDataService dataService,
                          EggGroupProseSerivce eggGroupProseSerivce) {
        this.eggGroupsService = eggGroupsService;
        this.speciesNamesService = speciesNamesService;
        this.connector = connector;
        this.breedingPathUtils = breedingPathUtils;
        this.dataService = dataService;
        this.eggGroupProseSerivce = eggGroupProseSerivce;
    }

    /**
     * Returns Egg group of a pokemon species
     * Used mainly for testing purposes. Delete later!
     *
     * @param speciesID
     * @return pokemon egg groups which belong to the species
     */
    public List<PokemonEggGroup> findEggGroupBySpeciesID(Long speciesID) {
        return eggGroupsService.findBySpeciesID(speciesID);
    }

    /**
     * Returns the number of egg groups
     * Used for testing purposes. Delete later!
     *
     * @return numbeer of egg groups
     */
    public Long findMaxEggGroupId() {
        return eggGroupsService.findMaxEggGroupId();
    }

    /**
     * Shows which egg groups are connected to which
     *
     * @return all egg group nodes
     */
    public List<EggGroupNode> findConnections() {
        return connector.getEggGroupNodes();
    }

    public List<List<Long>> searchFastestPath(Long from, Long to) {
        BreedingPathSearcher searcher = new BreedingPathSearcher(from, to, connector.getEggGroupNodes());
        return searcher.searchFastestPath();
    }

    public List<List<Long>> findBreedingPathBySpeciesIDs(Long from, Long to) {
        return breedingPathUtils.findBreedingPathBySpeciesIDs(from, to);
    }

    //TODO breeding path should show egg-grpups first decleration first
    //TODO create a response with: starting Pokemon (/eg group?) and all steps should contain their egg group
    //TODO names should be coming from pokemon_csv's where default is 1

    /**
     * This was used as informational method for testing. It is being replaced by a real pokemon response object
     * which has multiple properties required by front end
     *
     * @param from
     * @param to
     * @return
     */
    public List<List<List<String>>> findBreedingPathsWithNamesBySpecies(Long from, Long to) {
        return breedingPathUtils.getSpeciesNamesByBreedingPath(breedingPathUtils.findBreedingPathBySpeciesIDs(from, to));
    }

    /**
     * Mainly used for testing, possibly will need to be deleted
     *
     * @return all EnglishPokemon Names
     */
    public List<String> getEnglishPokemonNames() {
        return speciesNamesService.getAllEnglishNames();
    }

    //TODO delete when testing is done
    public PokemonNameSearchResponse getPokemonNameSearchDTOs(Long languageID) {
        List<PokemonDTO> nameSearchDTOs = speciesNamesService.getAllByLanguageID(languageID)
                                                        .stream()
                                                        .map(this::createPokemonDtoFromSpeciesName)
                                                        .collect(Collectors.toList());
        return new PokemonNameSearchResponse(nameSearchDTOs);
    }

    //TODO delete when testing is done
    private PokemonDTO createPokemonDtoFromSpeciesName(PokemonSpeciesName species) { //TODO nullpointer warning
        String identifier = dataService.findBySpeciesID(species.getPokemonSpeciesID()).getIdentifier();
        return new PokemonDTO(species.getName(), species.getPokemonSpeciesID(), species.getGenus(), identifier, null);
    }


    /**
     *
     * @param fromSpeciesID
     * @param toSpeciesID
     * @return
     */
    public PokemonBreedingResponse getBreedingPath(Long fromSpeciesID, Long toSpeciesID){
        PokemonBreedingResponse response = new PokemonBreedingResponse();
        response.setStartingPokemon(getPokemonFromSpeciesID(fromSpeciesID));
        response.setResultPokemon(getPokemonFromSpeciesID(toSpeciesID));

        List<PokemonEggGroup> fromGroups = eggGroupsService.findBySpeciesID(fromSpeciesID);
        List<PokemonEggGroup> toGroups = eggGroupsService.findBySpeciesID(toSpeciesID);

        boolean isPokemonsHaveCommonEggGroup = !CollectionUtils.isEmpty(fromGroups.stream().filter(group -> {
                                            return toGroups.stream()
                                                        .map(PokemonEggGroup::getEggGroupID)
                                                        .collect(Collectors.toList())
                                                        .contains(group.getEggGroupID());
                                        }).collect(Collectors.toList()));

        if(isPokemonsHaveCommonEggGroup){
            response.setPathStatus(BreedingPathStatus.DIRECTLY_BREEDABLE);
            return response;
        }

        List<List<Long>> rawBreedingPath = breedingPathUtils.findBreedingPathFromSpecies(fromGroups, toGroups);
        if(CollectionUtils.isEmpty(rawBreedingPath)){
            response.setPathStatus(BreedingPathStatus.NON_BREEDABLE);
            return response;
        }

        BreedingPathDTO breedingPath = getBreedingPathObjectFromRawBreedingPath(rawBreedingPath);
        response.setBreedingPath(breedingPath);
        response.setPathStatus(BreedingPathStatus.MULTISTEP_BREEDABLE);
        return response;
    }


    private PokemonDTO getPokemonFromSpeciesID(Long speciesID) {
        String name = speciesNamesService.getEnglishName(speciesID);
        String genus = speciesNamesService.getGenus(speciesID);
        String identifier = dataService.findBySpeciesID(speciesID).getIdentifier();
        List<String> eggGroups = eggGroupsService.findBySpeciesID(speciesID)
                .stream()
                .map(pokemonEggGroup -> eggGroupProseSerivce.getEnglishName(pokemonEggGroup.getEggGroupID()))
                .collect(Collectors.toList());
        return new PokemonDTO(name, speciesID, genus, identifier, eggGroups);
    }


    /**
     *
     * This should put together the JSONized breeding paths
     *
     * [ - container for all paths
     *   [ - one path
     *      [1,2,3] - path steps with species IDs
     *      [3,4,1]
     *   ]
     * ]
     *
     * @param breedingPathEggGroupIDs
     * @return
     */
    public BreedingPathDTO getBreedingPathObjectFromRawBreedingPath(List<List<Long>> breedingPathEggGroupIDs) {
        List<BreedingPathInstanceDTO> breedingPaths = new ArrayList<>();
        for(List<Long> path : breedingPathEggGroupIDs){
            List<BreedingStepDTO> breedingSteps = new ArrayList<>();
            for(int i = 0; i < path.size()-1; i++){
                BreedingStepDTO breedingStep = new BreedingStepDTO();
                breedingStep.setStartingEggGroupName(eggGroupProseSerivce.getEnglishName(path.get(i)));
                breedingStep.setResultEggGroupName(eggGroupProseSerivce.getEnglishName(path.get(i+1)));

                List<Long> firstGroupSpecies = eggGroupsService.findByEggGroupID(path.get(i))
                        .stream()
                        .map(PokemonEggGroup::getSpeciesID)
                        .collect(Collectors.toList());
                List<Long> secondGroupSpecies = eggGroupsService.findByEggGroupID(path.get(i+1))
                        .stream()
                        .map(PokemonEggGroup::getSpeciesID)
                        .collect(Collectors.toList());
                List<PokemonDTO> common = firstGroupSpecies.stream()
                        .filter(secondGroupSpecies::contains)
                        .map(this::getPokemonFromSpeciesID)
                        .collect(Collectors.toList());
                breedingStep.setPokemonsAtCurrentStep(common);
                breedingSteps.add(breedingStep);
            }
            BreedingPathInstanceDTO breedingPath = new BreedingPathInstanceDTO();
            breedingPath.setStartingEggGroupName(eggGroupProseSerivce.getEnglishName(path.get(0)));
            breedingPath.setResultEggGroupName(eggGroupProseSerivce.getEnglishName(path.get(path.size()-1)));
            breedingPath.setBreedingSteps(breedingSteps);
            breedingPaths.add(breedingPath);
        }
        return new BreedingPathDTO(breedingPaths);
    }
}
