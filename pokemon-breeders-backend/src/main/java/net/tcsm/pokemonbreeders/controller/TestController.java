package net.tcsm.pokemonbreeders.controller;

import net.tcsm.pokemonbreeders.dto.EggGroupNode;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.service.PokemonEggGroupsService;
import net.tcsm.pokemonbreeders.util.EggGroupConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PokemonEggGroupsService service;

    @Autowired
    private EggGroupConnector connector;

    @GetMapping
    public List<PokemonEggGroup> getEggGroup(@RequestParam Long speciesID){
        return service.findBySpeciesID(speciesID);
    }

    @GetMapping(path = "max")
    public Long findMaxEggGroupId(){
        return service.findMaxEggGroupId();
    }

    @GetMapping(path = "connect")
    public List<EggGroupNode> findConnections(){
        return connector.getEggGroupNodes();
    }
}
