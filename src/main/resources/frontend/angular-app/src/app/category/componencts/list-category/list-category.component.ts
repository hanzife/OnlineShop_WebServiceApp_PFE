import { Component, OnInit } from '@angular/core';
import { CategoryModule} from "../../category.module";
import { CategoryService} from "../../services/category.service";
import {CategoryRoutingModule} from "../../category-routing.module";
import {ProductModule} from "../../../product-component/product/product.module";

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.css']
})
export class ListCategoryComponent implements OnInit {

  categories?: CategoryRoutingModule[];
  currentCategory?: CategoryRoutingModule;
  currentIndex = -1;

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.retrieveCategories();
  }

  retrieveCategories(): void{
    this.categoryService.getAll()
      .subscribe(
        data => {
          this.categories = data.result;
          console.log(this.categories);
        },
        error => {
          console.log(error);
        });
  }

  setActiveCategory(category: CategoryModule, index: number): void {
    this.currentCategory = category;
    this.currentIndex = index;
  }


}
