import { Component, OnInit } from '@angular/core';
import { Album } from '../shared/model/Album';
import { ViewalbumService } from './viewalbum.service';
import { User } from '../Shared/model/User';

@Component({
  selector: 'app-viewalbum',
  templateUrl: './viewalbum.component.html',
  styleUrls: ['./viewalbum.component.css']
})
export class ViewalbumComponent implements OnInit {
  errorMessage: String;
  successMessage: String;
  likes:number=0;

 
  user:User;
  albums:Album[];
  constructor(private viewAlbumService:ViewalbumService) { }

  ngOnInit() {
    this.user=JSON.parse(sessionStorage.getItem('user'));
    this.viewAlbumService.getAlbum(this.user.username).subscribe(
      (res)=>{this.albums=res ,console.log(res)}
    )
  }

  addLikes(album:Album){
    this.errorMessage=null;
    this.successMessage=null;
 album.likesCount=album.likesCount+ 1;
    this.viewAlbumService.addLikes(album).subscribe(
      res=>{this.successMessage=res}
    )
  }

}
