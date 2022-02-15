package net.tcsm.pokemonbreeders.dto;

public class PokemonNameSearchDTO {

    private String name;
    private Long id;
    private String genus;
    private String identifierName;

    public PokemonNameSearchDTO(String name, Long id, String genus, String identifierName) {
        this.name = name;
        this.id = id;
        this.identifierName = identifierName;
        this.genus = genus;
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
}
