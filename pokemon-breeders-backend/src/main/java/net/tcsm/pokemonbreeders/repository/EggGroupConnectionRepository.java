package net.tcsm.pokemonbreeders.repository;

import net.tcsm.pokemonbreeders.model.EggGroupConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EggGroupConnectionRepository extends JpaRepository<EggGroupConnectionEntity, Long> {

    Optional<EggGroupConnectionEntity> findEggGroupConnectionByGroupIDAndConnectedGroupID(Long groupID, Long connectedGroupID);
    List<EggGroupConnectionEntity> findEggGroupConnectionsByGroupID(Long groupID);


}
