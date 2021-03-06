package net.tcsm.pokemonbreeders.dto;

public class PokemonBreedingResponse {

    PokemonDTO startingPokemon;
    PokemonDTO resultPokemon;
    BreedingPathStatus pathStatus;
    BreedingPathDTO breedingPath;

    public BreedingPathStatus getPathStatus() {
        return pathStatus;
    }

    public void setPathStatus(BreedingPathStatus pathStatus) {
        this.pathStatus = pathStatus;
    }

    public PokemonDTO getStartingPokemon() {
        return startingPokemon;
    }

    public void setStartingPokemon(PokemonDTO startingPokemon) {
        this.startingPokemon = startingPokemon;
    }

    public PokemonDTO getResultPokemon() {
        return resultPokemon;
    }

    public void setResultPokemon(PokemonDTO resultPokemon) {
        this.resultPokemon = resultPokemon;
    }

    public BreedingPathDTO getBreedingPath() {
        return breedingPath;
    }

    public void setBreedingPath(BreedingPathDTO breedingPath) {
        this.breedingPath = breedingPath;
    }
}
