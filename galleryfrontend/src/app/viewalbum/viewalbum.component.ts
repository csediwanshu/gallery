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
    this.viewAlbumService.getAlbum(this.user.username).subscribe(
      (res)=>{this.albums=res ,console.log(res)}
    )
    // this.activatedRoute.params.subscribe((params) => {
    //   console.log(params['id'])
    // })
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

}
