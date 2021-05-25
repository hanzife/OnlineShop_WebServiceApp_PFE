import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../services/product.service";
import {ProductModule} from "../../product/product.module";
import {ProductRoutingModule} from "../../product/product-routing.module";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  //products[] This where the data from db will be stored
  products?: ProductRoutingModule[];
  currentProduct?: ProductRoutingModule;
  currentIndex = -1;


  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.retrieveProducts();
  }

  retrieveProducts(): void{
    this.productService.getProducts()
      .subscribe(
        data => {
          this.products = data.result;
          console.log(this.products);
        },
        error => {
          console.log(error);
        });
  }

  setActiveProduct(product: ProductModule, index: number): void {
    this.currentProduct = product;
    this.currentIndex = index;
  }

}
