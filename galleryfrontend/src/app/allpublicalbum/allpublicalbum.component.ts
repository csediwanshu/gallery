import { Component, OnInit } from '@angular/core';
import { AllpublicalbumService } from './allpublicalbum.service';
import { Album } from '../shared/model/Album';

@Component({
  selector: 'app-allpublicalbum',
  templateUrl: './allpublicalbum.component.html',
  styleUrls: ['./allpublicalbum.component.css']
})
export class AllpublicalbumComponent implements OnInit {
  errorMessage: String;
  successMessage: String;
  constructor(private allpublicalbumService:AllpublicalbumService) { }

  albums:Album[];
  ngOnInit() {
    this.fetchAllPublicAlbums();
  }

  fetchAllPublicAlbums(){
    this.allpublicalbumService.fetchAllPublicAlbums().subscribe(
      res=>{this.albums=res,console.log(res);
      }
    )
  }
    addLikes(album:Album){
      this.errorMessage=null;
      this.successMessage=null;
   album.likesCount=album.likesCount+ 1;
    
      this.allpublicalbumService.addLikes(album).subscribe(
        res=>{this.successMessage=res}
      )
    }
  }



