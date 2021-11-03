package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.dto.EggGroupNode;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.dto.PokemonNameSearchDTO;
import net.tcsm.pokemonbreeders.dto.PokemonSpeciesName;
import net.tcsm.pokemonbreeders.util.BreedingPathSearcher;
import net.tcsm.pokemonbreeders.util.BreedingPathUtils;
import net.tcsm.pokemonbreeders.util.EggGroupConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main service of the project.
 * Responsible for providing data for PokemonController
 */
@Service
public class PokemonService {

    private final PokemonEggGroupsService eggGroupsService;
    private final PokemonSpeciesNamesSerivce speciesNamesSerivce;
    private final EggGroupConnector connector;
    private final BreedingPathUtils breedingPathUtils;
    private final PokemonDataSerivce dataSerivce;

    public PokemonService(PokemonEggGroupsService eggGroupsService, PokemonSpeciesNamesSerivce speciesNamesSerivce,
                          EggGroupConnector connector, BreedingPathUtils breedingPathUtils, PokemonDataSerivce dataSerivce) {
        this.eggGroupsService = eggGroupsService;
        this.speciesNamesSerivce = speciesNamesSerivce;
        this.connector = connector;
        this.breedingPathUtils = breedingPathUtils;
        this.dataSerivce = dataSerivce;
    }

    public List<PokemonEggGroup> findBySpeciesID(Long speciesID) {
        return eggGroupsService.findBySpeciesID(speciesID);
    }

    public Long findMaxEggGroupId() {
        return eggGroupsService.findMaxEggGroupId();
    }

    public List<EggGroupNode> findConnections() {
        return connector.getEggGroupNodes();
    }

    public List<List<Long>> searchFastestPath(@RequestParam Long from, @RequestParam Long to) {
        BreedingPathSearcher searcher = new BreedingPathSearcher(from, to, connector.getEggGroupNodes());
        return searcher.searchFastestPath();
    }

    public List<List<Long>> findBreedingPathsBySpecies(@RequestParam Long from, @RequestParam Long to) {
        return breedingPathUtils.findBreedingPathFromSpecies(from, to);
    }

    //TODO breeding path should show egg-grpups first decleration first
    //TODO create a response with: starting Pokemon (/eg group?) and all steps should contain their egg group
    //TODO names should be coming from pokemon_csv's where default is 1
    public List<List<List<String>>> findBreedingPathsWithNamesBySpecies(@RequestParam Long from, @RequestParam Long to) {
        return breedingPathUtils.getSpeciesNamesByBreedingPath(breedingPathUtils.findBreedingPathFromSpecies(from, to));
    }

    public List<String> getEnglishPokemonNames(){
        return speciesNamesSerivce.getAllEnglishNames();
    }

    public List<PokemonNameSearchDTO> getPokemonNameSearchDTOs(Long languageID) {
        return speciesNamesSerivce.getAllByLanguageID(languageID)
                .stream()
                .map(this::createNameSearchDtoFromSpeciesName)
                .collect(Collectors.toList());
    }

    private PokemonNameSearchDTO createNameSearchDtoFromSpeciesName(PokemonSpeciesName species){ //TODO nullpointer warning
        String identifier = dataSerivce.findBySpeciesID(species.getPokemonSpeciesID()).getIdentifier();
        return new PokemonNameSearchDTO(species.getName(), species.getPokemonSpeciesID(), species.getGenus(),identifier);
    }
}
