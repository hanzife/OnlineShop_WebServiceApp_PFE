import { Component, OnInit } from '@angular/core';
import {AuthRoutingModule} from "../../auth-routing.module";
import {AuthServiceService} from "../../services/auth-service.service";
import {HttpHeaders} from "@angular/common/http";
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: AuthRoutingModule = {
    username:'',
    email:'',
    password: '',
  };
  submitted = false;

  constructor(private authService: AuthServiceService) { }

  ngOnInit(): void {
  }

  saveUser(): void{

    //Gets json object from register.component.html form
    const data = {
      username: this.user.username,
      email: this.user.email,
      password: this.user.password
    };

    //when from submitted a service with post will be called
    this.authService.createUser(data).subscribe(
      response =>{
        console.log(response);
      },
      error => {
        console.log("error");
        console.log(error);
        console.log(data.email);
        console.log(data.password);
      });
  }

}
