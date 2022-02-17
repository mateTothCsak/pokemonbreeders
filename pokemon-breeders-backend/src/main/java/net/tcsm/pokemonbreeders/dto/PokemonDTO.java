package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class PokemonDTO {

    private String name;
    private Long id;
    private String genus;
    private String identifierName;
    private List<String> eggGroups;

    public PokemonDTO(String name, Long id, String genus, String identifierName, List<String> eggGroups) {
        this.name = name;
        this.id = id;
        this.identifierName = identifierName;
        this.genus = genus;
        this.eggGroups = eggGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public List<String> getEggGroups() {
        return eggGroups;
    }

    public void setEggGroups(List<String> eggGroups) {
        this.eggGroups = eggGroups;
    }
}
