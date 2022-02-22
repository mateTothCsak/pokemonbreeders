import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { PokemonService } from '../pokemon.service';
import { PokemonDTO } from '../dto/pokemon-dto';
import { BreedingPathDTO } from '../dto/breeding-path-dto';
import { BreedingResponse } from '../dto/breeding-response';
import { BreedingPathStatus } from '../dto/breeding-path-status';

@Component({
  selector: 'app-pokemon-picker',
  templateUrl: './pokemon-picker.component.html',
  styleUrls: ['./pokemon-picker.component.css']
})
export class PokemonPickerComponent implements OnInit {

  constructor(private pokemonService: PokemonService) {}

  pokemons: PokemonDTO[] = [];
  IMAGE_URL: string = "https://img.pokemondb.net/sprites/home/normal/";
  IMAGE_EXTENSION: string = ".png";
  startingPokemon? : PokemonDTO;
  resultPokemon? : PokemonDTO;
  numberOfEggGroups: string = "0";
  breedingPath?: BreedingResponse;
  breedingPathStatus = BreedingPathStatus;

  //pokemonLinks$: string[] = [];

  ngOnInit(): void {
    this.getSearchResultDTOs();
    this.getNumberOfEggGroups();
  }
  
  private getNumberOfEggGroups(): void {
    this.pokemonService.getNumberOfEgggroups().subscribe(response => this.numberOfEggGroups = response);
  }

  private getSearchResultDTOs(): void {
    this.pokemonService.getNameSearchDTOs().subscribe(response => { //TODO rename getPokemons
        this.pokemons = response.pokemons;
        this.startingPokemon = this.pokemons[0];
        this.resultPokemon = this.pokemons[0];
    });
  }

  public click(){
    console.log(this.startingPokemon);
    console.log(this.resultPokemon);
    if(this.startingPokemon && this.resultPokemon){
      this.pokemonService.getBreedingPaths(this.startingPokemon.id, this.resultPokemon.id).subscribe(response => {
        this.breedingPath = response;
        console.log(response);
      });
    }
    //else show error window (?) 
  }

  public click2(){
      console.log(this.breedingPath);
    }

}





      /*for (var pokemon of response.pokemons){
        this.pokemons.push(pokemon);
        console.log(pokemon);
        this.pokemonLinks$.push(this.IMAGE_URL + pokemon.identifierName + this.IMAGE_EXTENSION);
      }*/