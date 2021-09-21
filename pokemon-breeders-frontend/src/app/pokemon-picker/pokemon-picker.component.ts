import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-picker',
  templateUrl: './pokemon-picker.component.html',
  styleUrls: ['./pokemon-picker.component.css']
})
export class PokemonPickerComponent implements OnInit {

  constructor(private pokemonService: PokemonService) {}

  numberOfEggGroups$: string = "0";

  ngOnInit(): void {
    this.getNumberOfEggGroups();
  }
  
  private getNumberOfEggGroups(): void {
    this.pokemonService.getNumberOfEgggroups().subscribe(response => this.numberOfEggGroups$ = response);
  }

}
