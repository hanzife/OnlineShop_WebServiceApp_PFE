import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppComponentComponent } from './app-component/app-component.component';
import {AuthModule} from "./auth/auth.module";
import {RegisterComponent} from "./auth/components/register/register.component";
import {AuthRoutingModule} from "./auth/auth-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

//Declaring the url routes
const routes: Routes = [

  { path: '', redirectTo: 'login', pathMatch: 'full' }


];

@NgModule({
  declarations: [
    AppComponent,
    AppComponentComponent,
  ],
  imports: [
    BrowserModule,
    AuthModule,
    RouterModule,
    AuthRoutingModule, // CLI adds AppRoutingModule to the AppModule's imports array
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
