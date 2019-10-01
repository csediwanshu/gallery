import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {

  editalbum:boolean=false;
  constructor() { }

  ngOnInit() {
    sessionStorage.setItem('user', JSON.stringify(null))
  }

}
