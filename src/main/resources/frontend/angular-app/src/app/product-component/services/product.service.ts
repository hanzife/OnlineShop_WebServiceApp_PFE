import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductModule} from "../product/product.module";

const baseUrl = 'http://localhost:8080/create_product';
const getsProductsUrl = 'http://localhost:8080/categories/8/products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  //Create New Product
  createProduct(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  //Get The List Of Products
  getProducts(): Observable<any> {
    return this.http.get<any>(getsProductsUrl);
  }

  //Get Product by Category
  findByCategory(title: any): Observable<ProductModule[]> {
    return this.http.get<ProductModule[]>(`${baseUrl}?title=${title}`);
  }

}
