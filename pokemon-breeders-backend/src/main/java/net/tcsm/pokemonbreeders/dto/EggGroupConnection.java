package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class EggGroupConnection {

    private Long id;
    private List<Long> connectedEggGroups;


    public EggGroupConnection() {
    }

    public EggGroupConnection(Long id, List<Long> connectedEggGroups) {
        this.id = id;
        this.connectedEggGroups = connectedEggGroups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getConnectedEggGroups() {
        return connectedEggGroups;
    }

    public void setConnectedEggGroups(List<Long> connectedEggGroups) {
        this.connectedEggGroups = connectedEggGroups;
    }
}
