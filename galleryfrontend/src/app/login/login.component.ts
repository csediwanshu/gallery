import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { User } from '../Shared/model/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMessage: String;
  successMessage: String;
  username:String=null;
  password:String=null;
  sucessfulLogin:boolean=false;

  user:User;
  constructor(private loginService:LoginService,private router: Router) { }

  ngOnInit() {
  }
  checkin(frontUsername:String,frontPassword:String)
  {
    this.errorMessage=null;
      this.successMessage=null;
    this.username=frontUsername;
    this.password=frontPassword;
    console.log(this.username);

    this.loginService.checkLogin(this.username,this.password).subscribe(
     ses=>   { 
      sessionStorage.setItem('user', JSON.stringify(ses));
      // this.user  =JSON.parse(sessionStorage.getItem('user'));
      // console.log(this.user);
      this.router.navigate(['/home']); 
      },

      (err:HttpErrorResponse)=>{
        this.errorMessage = err.message;
      }
    )

  }
}
