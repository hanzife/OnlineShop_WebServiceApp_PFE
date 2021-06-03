import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import  {ProductModule} from "./product-component/product/product.module";

const baseUrl = 'http://localhost:8080/products';

@Injectable({
  providedIn: 'root'
})

export class AppServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(baseUrl);
  }

}
