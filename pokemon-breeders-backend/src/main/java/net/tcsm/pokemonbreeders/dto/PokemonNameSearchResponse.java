package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class PokemonNameSearchResponse {

    private List<PokemonNameSearchDTO> pokemons;

    public PokemonNameSearchResponse(List<PokemonNameSearchDTO> pokemons) {
        this.pokemons = pokemons;
    }

    public List<PokemonNameSearchDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonNameSearchDTO> pokemons) {
        this.pokemons = pokemons;
    }
}
