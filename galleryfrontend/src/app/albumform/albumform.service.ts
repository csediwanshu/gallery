import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { Album } from '../shared/model/Album';

import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AlbumformService {
  constructor(private http: HttpClient) { }

  addAlbum(album:Album):Observable<String>{
    const url = environment.addAlbumAPI +"/addAlbum";
    return this.http.post<String>(url,album).pipe(catchError(this.handleError));
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
