package net.tcsm.pokemonbreeders.repository;

import net.tcsm.pokemonbreeders.model.PokemonEggGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonEggGroupsRepository extends JpaRepository<PokemonEggGroupEntity, Long> {

    List<PokemonEggGroupEntity> findBySpeciesID(Long speciesID);
    List<PokemonEggGroupEntity> findByEggGroupID(Long eggGroupID);

    @Query("select max(t.eggGroupID) from PokemonEggGroupEntity t")
    Long findMaxEggroup();

}
