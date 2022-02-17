package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.dto.PokemonData;
import net.tcsm.pokemonbreeders.repository.PokemonDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.tcsm.pokemonbreeders.mapper.PokemonDataMapper.pokemonDataMapper;


@Service
public class PokemonDataService {

    private static final Long englishLanguageID = 9L;

    @Autowired
    private PokemonDataRepository repository;


    public PokemonData findBySpeciesID(Long speciesID){
        return pokemonDataMapper.toDto(repository.findFirstBySpeciesIDOrderById(speciesID));
    }

    public String findIdentitifierBySpeciesID(Long speciesID){
        return findBySpeciesID(speciesID).getIdentifier();
    }
}
