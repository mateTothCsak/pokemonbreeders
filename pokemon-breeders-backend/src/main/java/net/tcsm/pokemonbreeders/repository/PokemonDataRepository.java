package net.tcsm.pokemonbreeders.repository;

import net.tcsm.pokemonbreeders.model.PokemonDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonDataRepository extends JpaRepository<PokemonDataEntity, Long> {

    PokemonDataEntity findFirstBySpeciesIDOrderById(Long speciesID);

}
