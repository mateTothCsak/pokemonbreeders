package net.tcsm.pokemonbreeders.controller;

import net.tcsm.pokemonbreeders.dto.EggGroupNode;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.dto.PokemonNameSearchResponse;
import net.tcsm.pokemonbreeders.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping
    public List<PokemonEggGroup> getEggGroup(@RequestParam Long speciesID) {
        return service.findEggGroupBySpeciesID(speciesID);
    }

    /**
     * @return number of existing egg groups
     */
    @GetMapping(path = "max")
    public Long findMaxEggGroupId() {
        return service.findMaxEggGroupId();
    }

    /**
     * Connects egg groups
     *
     * @return lit of EggGroupNodes, containing information about which egg group is connected to which other
     */
    @GetMapping(path = "connect")
    public List<EggGroupNode> findEggGroupConnections() {
        return service.findConnections();
    }

    /**
     * Shows the breeding path from one egg group to another
     *
     *
     * @param from starting egg group id (example - 1 = monster, 2 = water1 etc)
     * @param to   destination egg group id
     * @return list of paths, containing the steps for breeding
     */
    @GetMapping(path = "egg-group-path")
    public List<List<Long>> findEggGroupPaths(@RequestParam Long from, @RequestParam Long to) {
        return service.searchFastestPath(from, to);
    }

    @GetMapping(path = "species-path")
    public List<List<Long>> findBreedingPathsBySpecies(@RequestParam Long from, @RequestParam Long to) {
        return service.findBreedingPathBySpeciesIDs(from, to);
    }

    @GetMapping(path = "species-names-path")
    public List<List<List<String>>> findBreedingPathsWithNamesBySpecies(@RequestParam Long from, @RequestParam Long to) {
        return service.findBreedingPathsWithNamesBySpecies(from, to);
    }

    @GetMapping("english-names")
    public List<String> getEnglishPokemonNames(){
        return service.getEnglishPokemonNames();
    }

    //TODO delete test endpoint
    @GetMapping("name-search-data")
    public PokemonNameSearchResponse getPokemonNameSearchDTOs(@RequestParam Long languageID){
        return service.getPokemonNameSearchDTOs(languageID);
    }
}
