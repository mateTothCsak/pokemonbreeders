package net.tcsm.pokemonbreeders.util;

import net.tcsm.pokemonbreeders.dto.EggGroupConnection;
import net.tcsm.pokemonbreeders.dto.PokemonEggGroup;
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

    public List<EggGroupConnection> generateEggGroupConnections(){
        List<EggGroupConnection> connections = new ArrayList<>();
        int numOfEggGroups = eggGroupsService.findMaxEggGroupId().intValue();
        for(int groupID = 1; groupID <= numOfEggGroups; groupID++) {
            List<Long> connectedGroups = getConnectedGroups((long) groupID);
            connections.add(new EggGroupConnection((long) groupID, connectedGroups));
        }
        return connections;
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

}
