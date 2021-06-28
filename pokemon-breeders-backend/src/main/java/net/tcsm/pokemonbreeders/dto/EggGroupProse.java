package net.tcsm.pokemonbreeders.dto;

public class EggGroupProse {

    private Long id;
    private Long eggGroupID;
    private Long localLanguageID;
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
