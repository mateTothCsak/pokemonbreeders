package net.tcsm.pokemonbreeders.dto;

public class PokemonNameSearchDTO {

    private String name;
    private Long id;
    private String genus;
    private String identitifierName;

    public PokemonNameSearchDTO(String name, Long id, String genus, String identitifierName) {
        this.name = name;
        this.id = id;
        this.identitifierName = identitifierName;
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

    public String getIdentitifierName() {
        return identitifierName;
    }

    public void setIdentitifierName(String identitifierName) {
        this.identitifierName = identitifierName;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
