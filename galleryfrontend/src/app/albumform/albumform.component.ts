import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlbumformService } from './albumform.service';
import { Album } from '../shared/model/Album';

@Component({
  selector: 'app-albumform',
  templateUrl: './albumform.component.html',
  styleUrls: ['./albumform.component.css']
})
export class AlbumformComponent implements OnInit {
  errorMessage: String;
  successMessage: String;
  album:Album;

  albumForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private albumFormService:AlbumformService ) { }

  ngOnInit() {
    this.album=new Album();
    this.albumForm=this.formBuilder.group({
      albumName:[this.album.albumName,Validators.required],
      description:[this.album.description,Validators.required]
    })
  }

  newAlbum()
  {
    this.errorMessage=null;
      this.successMessage=null;
      this.album=this.albumForm.value as Album;
    this.albumFormService.addAlbum(this.album).subscribe((res) => {
      this.successMessage =res;
    })
  }

}
