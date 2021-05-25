import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppComponentComponent } from './app-component/app-component.component';
import {AuthModule} from "./auth/auth.module";
import {AuthRoutingModule} from "./auth/auth-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { AddProductComponent } from './product-component/components/add-product/add-product.component';
import {ProductModule} from "./product-component/product/product.module";
import { ProductListComponent } from './product-component/components/product-list/product-list.component';
import { ListCategoryComponent } from './category/componencts/list-category/list-category.component';
import {CategoryModule} from "./category/category.module";
//Declaring the url routes
const routes: Routes = [

  { path: '', redirectTo: 'login', pathMatch: 'full' }



];

@NgModule({
  declarations: [
    //Components declared here
    AppComponent,
    AppComponentComponent,
    AddProductComponent,
    ProductListComponent,
    ListCategoryComponent,
  ],
  imports: [
    BrowserModule,
    AuthModule,
    ProductModule,
    CategoryModule,
    RouterModule,
    AuthRoutingModule, // CLI adds AppRoutingModule to the AppModule's imports array
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
