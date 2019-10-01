import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../Shared/model/User';
import { SignupService } from './signup.service';
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
  constructor(private formBuilder: FormBuilder,private signupService:SignupService) { }

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
      this.signupService.registerUser(this.user).subscribe(
        message=>{
          this.successMessage = message;
          this.registerUserForm.reset();

        }
        ,
        error=>{
          this.errorMessage=<any> error;
        }
      )
    }

    onUpload(event) {
      this.selectedFile = <File>event.target.files[0];
      var reader = new FileReader();
      reader.readAsDataURL(this.selectedFile);
      reader.onloadend = () =>{
        console.log(reader.result);
      }
      const fd = new FormData();
      fd.append('image', this.selectedFile, this.selectedFile.name);
       console.log(fd);
    }




}
