package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class PokemonNameSearchResponse {

    private List<PokemonDTO> pokemons;

    public PokemonNameSearchResponse(List<PokemonDTO> pokemons) {
        this.pokemons = pokemons;
    }

    public List<PokemonDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonDTO> pokemons) {
        this.pokemons = pokemons;
    }
}
