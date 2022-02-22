import { PokemonDTO } from "../dto/pokemon-dto";

export class PokemonNameSearchResponse {

    constructor(pokemons : PokemonDTO[]){
        this.pokemons = pokemons;
     }
 
     pokemons : PokemonDTO[] = [];
    
}
 