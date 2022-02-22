package net.tcsm.pokemonbreeders.dto;

import java.util.List;

/**
 * represents one single breeding path example
 */
public class BreedingPathInstanceDTO {

    String startingEggGroupName;
    String resultEggGroupName;
    List<BreedingStepDTO> breedingSteps;

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

    public List<BreedingStepDTO> getBreedingSteps() {
        return breedingSteps;
    }

    public void setBreedingSteps(List<BreedingStepDTO> breedingSteps) {
        this.breedingSteps = breedingSteps;
    }
}
