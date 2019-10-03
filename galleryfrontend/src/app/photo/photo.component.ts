import { Component, OnInit } from '@angular/core';
import { Photo } from '../shared/model/Photo';
import { PhotoService } from './photo.service';
import { Album } from '../shared/model/Album';
import { User } from '../Shared/model/User';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-photo',
  templateUrl: './photo.component.html',
  styleUrls: ['./photo.component.css']
})
export class PhotoComponent implements OnInit {

  photos:Photo[];
  album:Album;
  user:User;
  photoFormBool:boolean=true;

  errorMessage: String;
  successMessage: String;
  selectedFile:File;
  readerData: string;
  photoForm: FormGroup;
  activateSubmit:boolean=false;
  photo:Photo;
  constructor(private formBuilder: FormBuilder,private photoService:PhotoService,private router:Router) { }

  ngOnInit() {
    this.album=JSON.parse(sessionStorage.getItem('album'));
   this.user=JSON.parse(sessionStorage.getItem('user'));
   this.photoForm=this.formBuilder.group({
    description:[this.album.description,Validators.required]
  })
  this.fetchPhotos();
    }

    fetchPhotos()
    {
      this.photoService.getPhotos(this.album.albumId).subscribe(
        (res)=>{
          this.photos=res;
        }
      )
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
  
    uploadPhoto()
    {
        this.errorMessage=null;
        this.successMessage=null;
        this.photo=this.photoForm.value as Photo;
        this.photo.photoData=this.readerData;
        this.album=JSON.parse(sessionStorage.getItem('album'));
         this.photo.photoAlbumId=this.album.albumId;
         this.photoService.addPhoto(this.photo).subscribe(
           (res) => {
        this.successMessage =res;
        this.fetchPhotos();
      })

      this.photoFormBool=true;
    }

    addLike(photo1:Photo){
      this.errorMessage=null;
      this.successMessage=null;
   photo1.likesCount=photo1.likesCount+ 1;
      this.photoService.addLikes(photo1).subscribe(
        res=>{this.successMessage=res}
      )
    }

    removePhoto(photo:Photo){
      this.errorMessage=null;
      this.successMessage=null;
      this.photoService.removePhoto(photo).subscribe(
        res=>{this.successMessage=res}
      )
    }
  
}
