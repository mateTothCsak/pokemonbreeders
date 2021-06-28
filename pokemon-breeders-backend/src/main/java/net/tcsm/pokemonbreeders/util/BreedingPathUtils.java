package net.tcsm.pokemonbreeders.util;

import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.service.PokemonEggGroupsService;
import net.tcsm.pokemonbreeders.service.PokemonSpeciesNamesSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BreedingPathUtils {

    @Autowired
    private PokemonEggGroupsService eggGroupsService;

    @Autowired
    private EggGroupConnector connector;

    @Autowired
    private PokemonSpeciesNamesSerivce pokemonSpeciesNamesSerivce;

    public List<List<Long>> findBreedingPathFromSpecies(Long from, Long to){
        List<PokemonEggGroup> fromGroups = eggGroupsService.findBySpeciesID(from);
        List<PokemonEggGroup> toGroups = eggGroupsService.findBySpeciesID(to);
        int minLength = Integer.MAX_VALUE;
        List<List<Long>> resultPaths = new ArrayList<>();
        for(PokemonEggGroup fromGroup : fromGroups){
            for(PokemonEggGroup toGroup : toGroups){
                BreedingPathSearcher searcher = new BreedingPathSearcher(fromGroup.getEggGroupID(), toGroup.getEggGroupID(), connector.getEggGroupNodes());
                List<List<Long>> paths = searcher.searchFastestPath();
                if(!CollectionUtils.isEmpty(paths) && !CollectionUtils.isEmpty(paths.get(0))){
                    if(paths.get(0).size() < minLength){
                        resultPaths = paths;
                        minLength = paths.get(0).size();
                    } else if(paths.get(0).size() == minLength){
                        resultPaths.addAll(paths);
                    }
                }
            }
        }
        return resultPaths;
    }

    public List<List<List<Long>>> getSpeciesByBreedingPath(List<List<Long>> breedingPath) {
        List<List<List<Long>>> species = new ArrayList<>();
        for(List<Long> path : breedingPath){
            List<List<Long>> pathSpecies = new ArrayList<>();
            for(int i = 0; i < path.size()-1; i++){
                List<Long> firstGroupSpecies = eggGroupsService.findByEggGroupID(path.get(i))
                        .stream()
                        .map(PokemonEggGroup::getSpeciesID)
                        .collect(Collectors.toList());
                List<Long> secondGroupSpecies = eggGroupsService.findByEggGroupID(path.get(i+1))
                        .stream()
                        .map(PokemonEggGroup::getSpeciesID)
                        .collect(Collectors.toList());
                List<Long> common = firstGroupSpecies.stream()
                        .filter(secondGroupSpecies::contains)
                        .collect(Collectors.toList());
                pathSpecies.add(common);
            }
            species.add(pathSpecies);
        }
        return species;
    }

    public List<List<List<String>>> getSpeciesNamesByBreedingPath(List<List<Long>> breedingPath) {
        List<List<List<Long>>> species = getSpeciesByBreedingPath(breedingPath);
        List<List<List<String>>> speciesNames = new ArrayList<>();

        for(List<List<Long>> types : species){
            List<List<String>> typeNames = new ArrayList<>();
            for(List<Long> type : types) {
                typeNames.add(type
                        .stream()
                        .map(pokemonSpeciesNamesSerivce::getEnglishName)
                        .collect(Collectors.toList()));
            }
            speciesNames.add(typeNames);
        }
        return speciesNames;
    }
/*
    public String getSpeciesNamesByBreedingPath(List<List<Long>> breedingPath) {
        List<List<Long>> species = getSpeciesByBreedingPath(breedingPath);
        List<List<String>> speciesNames = new ArrayList<>();
        int pathCounter = 1;
        StringBuilder sb = new StringBuilder();
        for (List<Long> type : species) {
            sb.append("Breeding Path #").append(pathCounter).append(" \n");
            breedingPath.get(pathCounter - 1)
                    .stream()
                    .map(eggGroupProseSerivce::getEnglishName)
                    .forEach(name -> sb.append(name).append(" - "));
            sb.deleteCharAt(sb.lastIndexOf("-"));
            sb.append("\n").append("Species:").append("\n");
            /*
            speciesNames.add(type
                    .stream()
                    .map(pokemonSpeciesNamesSerivce::getEnglishName)
                    .collect(Collectors.toList())); //
            type.stream()
                    .map(pokemonSpeciesNamesSerivce::getEnglishName)
                    .forEach()
                    .collect(Collectors.toList());
            pathCounter++;
        }
        return speciesNames;
    }*/

}
