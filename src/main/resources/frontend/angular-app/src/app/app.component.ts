import {Component, OnInit} from '@angular/core';
import {CategoryRoutingModule} from "./category/category-routing.module";
import {ProductRoutingModule} from "./product-component/product/product-routing.module";
import {CategoryService} from "./category/services/category.service";
import {AppServiceService} from "./app-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  products?: ProductRoutingModule;
  currentProduct?: ProductRoutingModule;
  currentIndex = -1;

  title = 'angular-app';

  constructor(private appService: AppServiceService) { }

  ngOnInit(): void {
    this.retrieveProducts();
  }

  retrieveProducts(): void{
    this.appService.getAll()
      .subscribe(
        data => {
          this.products = data.result;
          console.log(this.products);
        },
        error => {
          console.log(error);
        });
  }

}
