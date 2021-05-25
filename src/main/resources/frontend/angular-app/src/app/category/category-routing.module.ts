import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListCategoryComponent} from "./componencts/list-category/list-category.component";

const routes: Routes = [
  {path: 'categories', component: ListCategoryComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryRoutingModule {
  id?: number;
  lableCategory?: string;
}
