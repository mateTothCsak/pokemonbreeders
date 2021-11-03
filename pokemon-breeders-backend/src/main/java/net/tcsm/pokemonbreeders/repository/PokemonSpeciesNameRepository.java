package net.tcsm.pokemonbreeders.repository;

import net.tcsm.pokemonbreeders.model.PokemonSpeciesNameEntity;
import net.tcsm.pokemonbreeders.service.PokemonSpeciesNamesSerivce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonSpeciesNameRepository extends JpaRepository<PokemonSpeciesNameEntity, Long> {

    List<PokemonSpeciesNameEntity> findAllByLocalLanguageID(Long localLanguageID);
    PokemonSpeciesNameEntity findByPokemonSpeciesIDAndLocalLanguageID(Long pokemonSpeciesID, Long localLanguageID);

}
