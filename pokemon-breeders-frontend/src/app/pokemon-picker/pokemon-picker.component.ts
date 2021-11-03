import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-picker',
  templateUrl: './pokemon-picker.component.html',
  styleUrls: ['./pokemon-picker.component.css']
})
export class PokemonPickerComponent implements OnInit {

  constructor(private pokemonService: PokemonService) {}

  IMAGE_URL: string = "https://img.pokemondb.net/sprites/home/normal/";
  IMAGE_EXTENSION: string = ".png";
  numberOfEggGroups$: string = "0";
  pokemons: string[] = ["charmander", "squirtle", "bulbasaur"];
  pokemonLinks$: string[] = [];

  ngOnInit(): void {
    this.getNumberOfEggGroups();
    this.updatePokemonLinks();
  }
  
  private getNumberOfEggGroups(): void {
    this.pokemonService.getNumberOfEgggroups().subscribe(response => this.numberOfEggGroups$ = response);
  }

  private updatePokemonLinks(): void {
    console.log("hello");
    for(let pokemon of this.pokemons){
        console.log(pokemon);
        this.pokemonLinks$.push(this.IMAGE_URL + pokemon + this.IMAGE_EXTENSION);
    }
  }

}
