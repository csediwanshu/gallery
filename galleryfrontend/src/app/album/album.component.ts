import { Component, OnInit } from '@angular/core';
import { Album } from '../shared/model/Album';
import { AlbumService } from './album.service';
import { User } from '../Shared/model/User';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {

  editalbum:boolean=false;
  albums:Album[];
  user:User;
  constructor(private albumService:AlbumService) { }
  

  ngOnInit() {
    this.user=JSON.parse(sessionStorage.getItem('user'));
      
    this.albumService.getAlbum(this.user.username).subscribe(
      res=>{
        this.albums=res;
      }
    )
    
  }

}
