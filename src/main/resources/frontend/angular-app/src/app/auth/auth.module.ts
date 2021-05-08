import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { RegisterComponent } from './components/register/register.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    RegisterComponent
  ],
    imports: [
        CommonModule,
        AuthRoutingModule,
        FormsModule
    ],
  exports: [
    RegisterComponent
  ]
})
export class AuthModule { }
