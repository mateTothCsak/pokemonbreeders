package net.tcsm.pokemonbreeders.dto;

import java.util.List;

public class BreedingPathDTO {

    List<BreedingPathInstanceDTO> breedingPathInstances;

    public BreedingPathDTO(List<BreedingPathInstanceDTO> breedingPaths) {
        this.breedingPathInstances = breedingPaths;
    }

    public List<BreedingPathInstanceDTO> getBreedingPathInstances() {
        return breedingPathInstances;
    }

    public void setBreedingPathInstances(List<BreedingPathInstanceDTO> breedingPathInstances) {
        this.breedingPathInstances = breedingPathInstances;
    }
}
