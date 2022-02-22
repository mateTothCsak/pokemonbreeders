package net.tcsm.pokemonbreeders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "egg_group_prose_csv")
public class EggGroupProseEntity {

    @Id
    @Column
    private Long id;

    @Column(name = "egg_group_id")
    private Long eggGroupID;

    @Column(name = "local_language_id")
    private Long localLanguageID;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEggGroupID() {
        return eggGroupID;
    }

    public void setEggGroupID(Long eggGroupID) {
        this.eggGroupID = eggGroupID;
    }

    public Long getLocalLanguageID() {
        return localLanguageID;
    }

    public void setLocalLanguageID(Long localLanguageID) {
        this.localLanguageID = localLanguageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
