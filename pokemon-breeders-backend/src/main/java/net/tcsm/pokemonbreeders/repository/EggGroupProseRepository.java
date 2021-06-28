package net.tcsm.pokemonbreeders.repository;

import net.tcsm.pokemonbreeders.model.EggGroupProseEntity;
import net.tcsm.pokemonbreeders.model.PokemonSpeciesNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggGroupProseRepository extends JpaRepository<EggGroupProseEntity, Long> {

    EggGroupProseEntity findByEggGroupIDAndLocalLanguageID(Long eggGroupID, Long localLanguageID);

}
