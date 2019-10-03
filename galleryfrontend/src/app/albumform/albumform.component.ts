import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlbumformService } from './albumform.service';
import { Album } from '../shared/model/Album';
import { Router } from '@angular/router';
import { User } from '../Shared/model/User';

@Component({
  selector: 'app-albumform',
  templateUrl: './albumform.component.html',
  styleUrls: ['./albumform.component.css']
})
export class AlbumformComponent implements OnInit {
  errorMessage: String;
  successMessage: String;
  album:Album;
selectedFile:File;
readerData: string;
  albumForm: FormGroup;
  activateSubmit:boolean=false;
user:User;
  constructor(private formBuilder: FormBuilder,private albumFormService:AlbumformService ,private router: Router) { }

  ngOnInit() {
    this.album=new Album();
    this.albumForm=this.formBuilder.group({
      albumName:[this.album.albumName,Validators.required],
      description:[this.album.description,Validators.required]
    })
  }

  onUpload(event) {
    this.selectedFile = <File> event.target.files[0];
    var reader = new FileReader();
    if(this.selectedFile) {
          reader.readAsDataURL(this.selectedFile);
          reader.onloadend = () => {
                this.readerData= reader.result.toString();
                this.activateSubmit= true;
           }
    }
  }

  newAlbum()
  {
    this.errorMessage=null;
      this.successMessage=null;
      this.album=this.albumForm.value as Album;
      this.album.coverPhoto=this.readerData;
      this.user  =JSON.parse(sessionStorage.getItem('user'));
       this.album.albumUser=this.user.username;

       this.albumFormService.addAlbum(this.album).subscribe(
         
         (res) => {
      this.successMessage =res;
      this.router.navigate(['/home']);
    })
  }

}
