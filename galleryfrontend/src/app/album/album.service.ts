import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  constructor(private httpService: HttpClient) { }

  
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
