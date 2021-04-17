package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class EggGroupNode {

    Long groupID;
    List<Long> connectedGroups;

    public EggGroupNode() {
    }

    public EggGroupNode(Long groupID, List<Long> connectedGroups) {
        this.groupID = groupID;
        this.connectedGroups = connectedGroups;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public List<Long> getConnectedGroups() {
        return connectedGroups;
    }

    public void setConnectedGroups(List<Long> connectedGroups) {
        this.connectedGroups = connectedGroups;
    }
}
