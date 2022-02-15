import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { PokemonService } from '../pokemon.service';
import { PokemonNameSearchDTO } from './pokemon-name-search-dto';

@Component({
  selector: 'app-pokemon-picker',
  templateUrl: './pokemon-picker.component.html',
  styleUrls: ['./pokemon-picker.component.css']
})
export class PokemonPickerComponent implements OnInit {

  constructor(private pokemonService: PokemonService) {}

  IMAGE_URL: string = "https://img.pokemondb.net/sprites/home/normal/";
  IMAGE_EXTENSION: string = ".png";
  startingPokemon : PokemonNameSearchDTO | undefined;
  resultPokemon : PokemonNameSearchDTO | undefined;
  numberOfEggGroups$: string = "0";
  pokemons: PokemonNameSearchDTO[] = [];
  
  //pokemonLinks$: string[] = [];

  ngOnInit(): void {
    this.getSearchResultDTOs();
    this.getNumberOfEggGroups();
  }
  
  private getNumberOfEggGroups(): void {
    this.pokemonService.getNumberOfEgggroups().subscribe(response => this.numberOfEggGroups$ = response);
  }

  private getSearchResultDTOs(): void {
    this.pokemonService.getNameSearchDTOs().subscribe(response => {
        this.pokemons = response.pokemons;
        this.startingPokemon = response.pokemons[0];
        this.resultPokemon = response.pokemons[0];
    });
  }

  public click(){
    console.log(this.startingPokemon);
    console.log(this.resultPokemon);
  }

}





      /*for (var pokemon of response.pokemons){
        this.pokemons.push(pokemon);
        console.log(pokemon);
        this.pokemonLinks$.push(this.IMAGE_URL + pokemon.identifierName + this.IMAGE_EXTENSION);
      }*/