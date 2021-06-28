package net.tcsm.pokemonbreeders.repository;

import net.tcsm.pokemonbreeders.model.PokemonSpeciesNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonSpeciesNameRepository extends JpaRepository<PokemonSpeciesNameEntity, Long> {

    PokemonSpeciesNameEntity findByPokemonSpeciesIDAndLocalLanguageID(Long pokemonSpeciesID, Long localLanguageID);

}
