import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { User } from '../Shared/model/User';
import { Observable, throwError } from 'rxjs';

import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class SignupService {

  // private headers=new HttpHeaders({'Content-Type':'application/json','Access-Control-Allow-Origin': '*' });
  constructor(private http:HttpClient) { }
  
  registerUser(user:User):Observable<any>{
    const url=environment.userAPIUrl  +'/registerUser/'
    return this.http.post(url,user,  { responseType: 'text'}).pipe(catchError(this.handleError));
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
