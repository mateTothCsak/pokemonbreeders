import { PokemonNameSearchDTO } from "./pokemon-name-search-dto";

export class PokemonNameSearchResponse {

    constructor(pokemons : PokemonNameSearchDTO[]){
        this.pokemons = pokemons;
     }
 
     pokemons : PokemonNameSearchDTO[] = [];
    
}
 