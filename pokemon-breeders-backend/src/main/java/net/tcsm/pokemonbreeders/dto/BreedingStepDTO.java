package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class BreedingStepDTO {

    String startingEggGroupName;
    String resultEggGroupName;
    List<PokemonDTO> pokemonsAtCurrentStep;

    public String getStartingEggGroupName() {
        return startingEggGroupName;
    }

    public void setStartingEggGroupName(String startingEggGroupName) {
        this.startingEggGroupName = startingEggGroupName;
    }

    public String getResultEggGroupName() {
        return resultEggGroupName;
    }

    public void setResultEggGroupName(String resultEggGroupName) {
        this.resultEggGroupName = resultEggGroupName;
    }

    public List<PokemonDTO> getPokemonsAtCurrentStep() {
        return pokemonsAtCurrentStep;
    }

    public void setPokemonsAtCurrentStep(List<PokemonDTO> pokemonsAtCurrentStep) {
        this.pokemonsAtCurrentStep = pokemonsAtCurrentStep;
    }
}
