package net.tcsm.pokemonbreeders.model;

import javax.persistence.*;

@Entity
@Table(name = "egg_group_connections")
public class EggGroupConnectionEntity {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_id")
    private Long groupID;

    @Column(name = "connected_group_id")
    private Long connectedGroupID;

    public EggGroupConnectionEntity() {
    }

    public EggGroupConnectionEntity(Long groupID, Long connectedGroupID) {
        this.groupID = groupID;
        this.connectedGroupID = connectedGroupID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
