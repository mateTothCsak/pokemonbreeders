package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.dto.PokemonSpeciesName;
import net.tcsm.pokemonbreeders.model.PokemonSpeciesNameEntity;
import net.tcsm.pokemonbreeders.repository.PokemonSpeciesNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static net.tcsm.pokemonbreeders.mapper.PokemonSpeciesNameMapper.pokemonSpeciesNameMapper;


@Service
public class PokemonSpeciesNamesSerivce {

    private static final Long englishLanguageID = 9L;

    @Autowired
    private PokemonSpeciesNameRepository repository;

    public String getEnglishName(Long speciesId) {
        return repository.findByPokemonSpeciesIDAndLocalLanguageID(speciesId, englishLanguageID).getName();
    }

    public String getGenus(Long speciesId) {
        return repository.findByPokemonSpeciesIDAndLocalLanguageID(speciesId, englishLanguageID).getGenus();
    }

    public List<String> getAllEnglishNames(){
        return repository.findAllByLocalLanguageID(englishLanguageID)
                .stream()
                .map(PokemonSpeciesNameEntity::getName)
                .collect(Collectors.toList());
    }

    public List<PokemonSpeciesName> getAllByLanguageID(Long languageID){
        return repository.findAllByLocalLanguageID(languageID)
                .stream()
                .map(pokemonSpeciesNameMapper::toDto)
                .collect(Collectors.toList());
    }
}
