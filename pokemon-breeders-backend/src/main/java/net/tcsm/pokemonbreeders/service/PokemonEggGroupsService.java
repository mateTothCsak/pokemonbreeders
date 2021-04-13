package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.model.PokemonEggGroupEntity;
import net.tcsm.pokemonbreeders.repository.PokemonEggGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static net.tcsm.pokemonbreeders.mapper.PokemonEggGroupMapper.pokemonEggGroupMapper;

@Transactional
@Service
public class PokemonEggGroupsService {

    @Autowired
    private PokemonEggGroupsRepository repository;

    public List<PokemonEggGroup> findBySpeciesID(Long speciesID) {

        return repository.findBySpeciesID(speciesID)
                .stream()
                .map(pokemonEggGroupMapper::toDto)
                .collect(Collectors.toList());
    }

    public Long findMaxEggGroupId(){
        return repository.findMaxEggroup();
    }

    public List<PokemonEggGroup> findByEggGroupID(Long eggGroupID) {
        return repository.findByEggGroupID(eggGroupID)
                .stream()
                .map(pokemonEggGroupMapper::toDto)
                .collect(Collectors.toList());
    }
}
