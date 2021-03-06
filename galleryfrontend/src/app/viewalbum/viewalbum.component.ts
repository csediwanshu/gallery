import { Component, OnInit } from '@angular/core';
import { Album } from '../shared/model/Album';
import { ViewalbumService } from './viewalbum.service';
import { User } from '../Shared/model/User';
import { Router, ActivatedRoute } from '@angular/router';

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
  constructor(private viewAlbumService:ViewalbumService,private router:Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.user=JSON.parse(sessionStorage.getItem('user'));
    this.fetchAlbum();
    // this.activatedRoute.params.subscribe((params) => {
    //   console.log(params['id'])
    // })
  }
  fetchAlbum(){
    this.viewAlbumService.getAlbum(this.user.username).subscribe(
      (res)=>{this.albums=res}
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
  intoAlbum(album:Album){
    sessionStorage.setItem('album',JSON.stringify(album));
    this.router.navigate(['/home/photo']);
  }
  removeAlbum(album:Album){
    this.errorMessage=null;
    this.successMessage=null;
    this.viewAlbumService.removeAlbum(album).subscribe(
      (res)=>{this.successMessage=res
        this.fetchAlbum();
      
      }
    )
  }

  changeAccess(album:Album){
    this.errorMessage=null;
    this.successMessage=null;
    console.log(album);
    
    this.viewAlbumService.changeAccess(album).subscribe(
      res=>{console.log(res);
         this.successMessage=res;this.fetchAlbum();}
    )
  }
}
