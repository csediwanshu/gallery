import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Photo } from '../shared/model/Photo';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  constructor(private http:HttpClient) { }

  getPhotos(albumId:number):Observable<Photo[]>{
    const url = environment.photoAPI+'/getPhotos'
    return this.http.post<Photo[]>(url,albumId).pipe(catchError(this.handleError));
  }

  addPhoto(photo:Photo):Observable<any>{
    const url = environment.photoAPI+'/addPhoto'
    return this.http.post(url,photo,{responseType:'text'}).pipe(catchError(this.handleError));

  }

  addLikes(photo:Photo):Observable<any>{
    const url = environment.photoAPI+'/addLikes'
    return this.http.post(url,photo,{responseType:'text'}).pipe(catchError(this.handleError));
  }

  removePhoto(photo:Photo):Observable<any>{
    const url = environment.photoAPI+'/removePhoto'
    return this.http.post(url,photo,{responseType:'text'}).pipe(catchError(this.handleError));
  }


  private handleError(err: HttpErrorResponse) {
    console.log(err);
    let errMsg:String="";
    if(err.error instanceof Error){
      errMsg=err.error.message;
      console.log(errMsg);
    }
    else if(typeof err.error== 'string')
    {
      errMsg=JSON.parse(err.error).message;
    }
    else{
      if(err.status==0){
        errMsg="A connection to back end can not  be established.";
      }
      else{
        errMsg=err.error.message;
      }
    }
   return throwError(errMsg);
}
}
