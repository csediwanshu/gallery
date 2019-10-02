import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { AlbumComponent } from './album/album.component';
import { HomeComponent } from './home/home.component';
import { PhotoComponent } from './photo/photo.component';
import { AlbumformComponent } from './albumform/albumform.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path:'signup',component: SignupComponent}, 
  {path: 'login',component: LoginComponent},
  
  {path: 'home', component: HomeComponent, children: [
    {path: 'album',component: AlbumComponent},
    {path: 'photo',component: PhotoComponent},
    {path: 'albumform',component:AlbumformComponent}
 
  ]},
  
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
