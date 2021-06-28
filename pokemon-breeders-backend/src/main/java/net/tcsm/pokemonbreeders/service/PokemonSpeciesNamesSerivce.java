package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.repository.PokemonSpeciesNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonSpeciesNamesSerivce {

    private static final Long englishLanguageID = 9L;

    @Autowired
    private PokemonSpeciesNameRepository repository;

    public String getEnglishName(Long speciesId) {
        return repository.findByPokemonSpeciesIDAndLocalLanguageID(speciesId, englishLanguageID).getName();
    }
}
