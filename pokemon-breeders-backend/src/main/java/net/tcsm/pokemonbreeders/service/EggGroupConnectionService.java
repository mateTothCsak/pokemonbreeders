package net.tcsm.pokemonbreeders.service;

import net.tcsm.pokemonbreeders.dto.EggGroupConnection;
import net.tcsm.pokemonbreeders.model.EggGroupConnectionEntity;
import net.tcsm.pokemonbreeders.repository.EggGroupConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static net.tcsm.pokemonbreeders.mapper.EggGroupConnectionMapper.eggGroupConnectionMapper;

@Transactional
@Service
public class EggGroupConnectionService {

    @Autowired
    private EggGroupConnectionRepository repository;
    
    public void createConnections(Long groupID, List<Long> connectedGroups) {
        connectedGroups.forEach(connectedGroup -> save(groupID, connectedGroup));
    }

    public void save(Long groupID, Long connectedGroupID) {
        if(repository.findEggGroupConnectionByGroupIDAndConnectedGroupID(groupID, connectedGroupID).isEmpty()) {
            repository.save(new EggGroupConnectionEntity(groupID, connectedGroupID));
        }
    }


    public List<EggGroupConnection> findByGroupID(Long groupID){
        return eggGroupConnectionMapper.toDtoList(repository.findEggGroupConnectionsByGroupID(groupID));
    }
}
