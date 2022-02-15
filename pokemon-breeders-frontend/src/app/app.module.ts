import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PokemonPickerComponent } from './pokemon-picker/pokemon-picker.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    PokemonPickerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
