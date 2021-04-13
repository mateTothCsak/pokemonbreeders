package net.tcsm.pokemonbreeders.dto;

public class PokemonEggGroup {

    private Long id;
    private Long speciesID;
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
