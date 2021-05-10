import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddProductComponent} from "../components/add-product/add-product.component";

const routes: Routes = [
  {path: 'add-product', component: AddProductComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule {
  nameProduct?: string;
  descriptionProduct?: string;
  qntStockProduct?: number;
  category?: number;

}
