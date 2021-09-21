package net.tcsm.pokemonbreeders.controller;

import net.tcsm.pokemonbreeders.dto.EggGroupNode;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.service.PokemonEggGroupsService;
import net.tcsm.pokemonbreeders.util.BreedingPathSearcher;
import net.tcsm.pokemonbreeders.util.BreedingPathUtils;
import net.tcsm.pokemonbreeders.util.EggGroupConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PokemonEggGroupsService service;

    @Autowired
    private EggGroupConnector connector;

    @Autowired
    private BreedingPathUtils breedingPathUtils;

    @GetMapping
    public List<PokemonEggGroup> getEggGroup(@RequestParam Long speciesID) {
        return service.findBySpeciesID(speciesID);
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
    public List<EggGroupNode> findConnections() {
        return connector.getEggGroupNodes();
    }

    /**
     * Shows the breeding path from one egg group to another
     *
     * @param from starting egg group id
     * @param to   destination egg group id
     * @return list of paths, containing the steps for breeding
     */
    @GetMapping(path = "paths")
    public List<List<Long>> findPaths(@RequestParam Long from, @RequestParam Long to) {
        BreedingPathSearcher searcher = new BreedingPathSearcher(from, to, connector.getEggGroupNodes());
        return searcher.searchFastestPath();
    }

    @GetMapping(path = "species-path")
    public List<List<Long>> findPathsBySpecies(@RequestParam Long from, @RequestParam Long to) {
        return breedingPathUtils.findBreedingPathFromSpecies(from, to);
    }

    //TODO breeding path should show egg-grpups first decleration first
    //TODO create a response with: starting Pokemon (/eg group?) and all steps should contain their egg group
    //TODO names should be coming from pokemon_csv's where default is 1
    @GetMapping(path = "species-names-path")
    public List<List<List<String>>> findPathsWithNamesBySpecies(@RequestParam Long from, @RequestParam Long to) {
        return breedingPathUtils.getSpeciesNamesByBreedingPath(breedingPathUtils.findBreedingPathFromSpecies(from, to));
    }
}
