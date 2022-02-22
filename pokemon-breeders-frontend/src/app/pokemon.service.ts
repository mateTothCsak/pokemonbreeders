import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { PokemonNameSearchResponse } from './pokemon-picker/pokemon-name-search-response';
import { BreedingResponse } from './dto/breeding-response';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  private maxResultsURL = "http://localhost:8080/pokemon/max";
  private englishNamesURL = "http://localhost:8080/pokemon/name-search-data?languageID=9";
  private breedingPathURL = "http://localhost:8080/pokemon/breeding-path";

  public getNumberOfEgggroups() {
    return this.http.get(this.maxResultsURL, {responseType: 'text'})
      .pipe(
        tap(
          data => console.log(data),
          error => console.log(error)
        )
      );
  }

  public getNameSearchDTOs() {
    return this.http.get<PokemonNameSearchResponse>(this.englishNamesURL, {responseType: 'json'});
  }

  public getBreedingPaths(fromSpeciesID: number, toSpeciesID: number) {
    return this.http.get<BreedingResponse>(this.getBreedingPathURL(fromSpeciesID, toSpeciesID), {responseType: 'json'});
  }

  private getBreedingPathURL(fromSpeciesID: number, toSpeciesID: number){
    return this.breedingPathURL + "?fromSpeciesID=" + fromSpeciesID + "&toSpeciesID=" + toSpeciesID;
    }

}
