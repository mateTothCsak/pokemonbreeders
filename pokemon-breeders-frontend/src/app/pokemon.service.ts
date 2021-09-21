import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  private maxResultsURL = "http://localhost:8080/test/max";

  public getNumberOfEgggroups() {
    return this.http.get(this.maxResultsURL, {responseType: 'text'})
      .pipe(
        tap(
          data => console.log(data),
          error => console.log(error)
        )
      );
  }
}
