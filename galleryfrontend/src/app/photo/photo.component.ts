import { Component, OnInit } from '@angular/core';
import { Photo } from '../shared/model/Photo';
import { PhotoService } from './photo.service';
import { Album } from '../shared/model/Album';
import { User } from '../Shared/model/User';

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
  constructor(private photoService:PhotoService) { }

  ngOnInit() {
    this.album=JSON.parse(sessionStorage.getItem('album'));
   this.user=JSON.parse(sessionStorage.getItem('user'));
    
    this.photoService.getPhotos(this.album.albumId).subscribe(
      (res)=>{
        this.photos=res;
      }
    )}

}
