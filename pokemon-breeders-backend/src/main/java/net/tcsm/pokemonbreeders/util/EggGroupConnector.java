package net.tcsm.pokemonbreeders.util;

import net.tcsm.pokemonbreeders.dto.EggGroupConnection;
import net.tcsm.pokemonbreeders.dto.EggGroupNode;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
import net.tcsm.pokemonbreeders.service.EggGroupConnectionService;
import net.tcsm.pokemonbreeders.service.PokemonEggGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EggGroupConnector {

    @Autowired
    private PokemonEggGroupsService eggGroupsService;

    @Autowired
    private EggGroupConnectionService eggGroupConnectionService;

    public void generateEggGroupConnections(){
        long numOfEggGroups = eggGroupsService.findMaxEggGroupId();
        for(long groupID = 1; groupID <= numOfEggGroups; groupID++) {
            List<Long> connectedGroups = getConnectedGroups(groupID);
            eggGroupConnectionService.createConnections(groupID, connectedGroups);
        }
    }

    private List<Long> getConnectedGroups(Long groupID) {
        return eggGroupsService.findByEggGroupID(groupID)
                .stream()
                .map(PokemonEggGroup::getSpeciesID)
                .map(eggGroupsService::findBySpeciesID)
                .flatMap(x -> x.stream())
                .map(PokemonEggGroup::getEggGroupID)
                .filter(eggGroupID -> !eggGroupID.equals(groupID))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<EggGroupNode> getEggGroupNodes() {
        List<EggGroupNode> nodes = new ArrayList<>();
        long numOfEggGroups = eggGroupsService.findMaxEggGroupId();
        for (long groupID = 1; groupID <= numOfEggGroups; groupID++) {
            List<Long> connectedGroupIDs = eggGroupConnectionService.findByGroupID(groupID)
                    .stream()
                    .map(EggGroupConnection::getConnectedGroupID)
                    .collect(Collectors.toList());
            nodes.add(new EggGroupNode(groupID, connectedGroupIDs));
        }
        return nodes;
    }
}
