package net.tcsm.pokemonbreeders.dto;

public class PokemonSpeciesName {

    private Long id;
    private Long pokemonSpeciesID;
    private Long localLanguageID;
    private String name;
    private String genus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokemonSpeciesID() {
        return pokemonSpeciesID;
    }

    public void setPokemonSpeciesID(Long pokemonSpeciesID) {
        this.pokemonSpeciesID = pokemonSpeciesID;
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

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
