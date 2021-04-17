package net.tcsm.pokemonbreeders.dto;

public class EggGroupConnection {


    private Long groupID;
    private Long connectedGroupID;

    public EggGroupConnection() {
    }

    public EggGroupConnection(Long groupID, Long connectedGroupID) {
        this.groupID = groupID;
        this.connectedGroupID = connectedGroupID;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public Long getConnectedGroupID() {
        return connectedGroupID;
    }

    public void setConnectedGroupID(Long connectedGroupID) {
        this.connectedGroupID = connectedGroupID;
    }

}
