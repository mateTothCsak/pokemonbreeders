package net.tcsm.pokemonbreeders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon_egg_groups_csv")
public class PokemonEggGroupEntity {

    @Id
    @Column
    private Long id;

    @Column(name = "species_id")
    private Long speciesID;

    @Column(name = "egg_group_id")
    private Long eggGroupID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(Long speciesID) {
        this.speciesID = speciesID;
    }

    public Long getEggGroupID() {
        return eggGroupID;
    }

    public void setEggGroupID(Long eggGroupID) {
        this.eggGroupID = eggGroupID;
    }
}
