import { Component, OnInit } from '@angular/core';
import {ProductRoutingModule} from "../../product/product-routing.module";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  //product Modul from routing
  product: ProductRoutingModule={
    nameProduct:'',
    descriptionProduct:'',
    qntStockProduct:0,
    category:0,
  }
  submitted = false;

  //Our Product Service with (CRUD functions called by UI buttons)
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  saveProduct(): void {
    const data = {
      nameProduct: this.product.nameProduct,
      descriptionProduct: this.product.descriptionProduct,
      qntStockProduct: this.product.qntStockProduct,
      category: 8,
    };

    this.productService.createProduct(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

}
