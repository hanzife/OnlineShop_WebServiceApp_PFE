import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddProductComponent} from "../components/add-product/add-product.component";
import {ProductListComponent} from "../components/product-list/product-list.component";

const routes: Routes = [
  {path: 'add-product', component: AddProductComponent},
  {path: 'products', component: ProductListComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule {
  nameProduct?: string;
  descriptionProduct?: string;
  qntStockProduct?: number;
  priceProduct?: number;
  category?: number;
}
