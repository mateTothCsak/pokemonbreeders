package net.tcsm.pokemonbreeders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon_species_names_csv")
public class PokemonSpeciesNameEntity {

    @Id
    @Column
    private Long id;

    @Column(name = "pokemon_species_id")
    private Long pokemonSpeciesID;

    @Column(name = "local_language_id")
    private Long localLanguageID;

    @Column
    private String name;

    @Column
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
