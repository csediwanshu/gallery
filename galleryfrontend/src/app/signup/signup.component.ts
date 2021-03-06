import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../Shared/model/User';
import { SignupService } from './signup.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  errorMessage: String;
  successMessage: String;
  user:User;
  registerUserForm: FormGroup;
  selectedFile: File;
  activateSubmit = false;
  readerData: string;
  constructor(private formBuilder: FormBuilder,private signupService:SignupService,private router:Router) { }

  ngOnInit() {
    this.user=new User();
    this.registerUserForm = this.formBuilder.group({
      email:[this.user.email,[Validators.required]],
      username:[this.user.username,[Validators.required]],
      firstName:[this.user.firstName,[Validators.required]],
      lastName:[this.user.lastName,[Validators.required]],
      gender:[this.user.gender,[Validators.required]],
      password:[this.user.password,[Validators.required]]
      })
    };

    registerUser(){
      this.errorMessage=null;
      this.successMessage=null;
      this.user=this.registerUserForm.value as User;
      this.user.profilePicture=this.readerData;
      this.signupService.registerUser(this.user).subscribe(
        message=>{
          this.successMessage = message;
          this.registerUserForm.reset();
        },
        error=>{this.errorMessage=<any> error;}
      )
      this.router.navigate(["/login"]);
    }

    onUpload(event) {
      this.selectedFile = <File>event.target.files[0];
      var reader = new FileReader();
      if(this.selectedFile) {
            reader.readAsDataURL(this.selectedFile);
            reader.onloadend = () => {
                  this.readerData= reader.result.toString();
                  this.activateSubmit= true;
           }
      }
      
      // const fd = new FormData();
      // fd.append('image', this.selectedFile, this.selectedFile.name);
      //  console.log(fd);
    }




}
