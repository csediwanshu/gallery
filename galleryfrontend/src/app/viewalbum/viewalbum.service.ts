import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';
import { Album } from '../shared/model/Album';

@Injectable({
  providedIn: 'root'
})
export class ViewalbumService {

  constructor(private http:HttpClient) { }

  getAlbum(username:String):Observable<Album[]>{

    const url=environment.addAlbumAPI  +'/getAlbum/';
    return this.http.post<Album[]>(url,username).pipe(catchError(this.handleError));
 
  }
  
  addLikes(album:Album):Observable<any>{
    const url=environment.addAlbumAPI  +'/addLikes/';
    return this.http.post(url,album,{ responseType: 'text'}).pipe(catchError(this.handleError));
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
