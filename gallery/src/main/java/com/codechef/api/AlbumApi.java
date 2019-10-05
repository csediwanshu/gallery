package com.codechef.api;

import java.util.List;

import com.codechef.model.Album;
import com.codechef.service.UserAlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@CrossOrigin
@RestController     
@RequestMapping("albumAPI")
public class AlbumApi{
    
    @Autowired
    private UserAlbumService userAlbumService;
    @PostMapping(value="addAlbum")
    public ResponseEntity<?> addAlbum(@RequestBody Album album) throws Exception  {
        try{
        userAlbumService.addAlbum(album);   
		String successMessage = "Album added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
        return response;
    }
        
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    
    @PostMapping(value="getAlbum")
    public ResponseEntity<?> getAlbum(@RequestBody String username) throws Exception  {
        try{
        List<Album> albums= userAlbumService.getAlbum(username);   
		ResponseEntity<List<Album>> response = new ResponseEntity<List<Album>>(albums, HttpStatus.OK);
        return response;
    }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    
    @PostMapping(value="addLikes")
    public ResponseEntity<?> addLikes(@RequestBody Album album) throws Exception  {
        try{   
        userAlbumService.addLikes(album);   
		String successMessage = "Album added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
        return response;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping(value="removeAlbum")
    public ResponseEntity<?> removeAlbum(@RequestBody Album album) throws Exception  {
        try{ 
        userAlbumService.removeAlbum(album);   
		String successMessage = "Album removed successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
        return response;
    }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping(value="changeAccess")
    public ResponseEntity<?> changeAccess(@RequestBody Album album) throws Exception  {
        try{ 
            System.err.println("xvyujgyuedhudehbckdbunsckunsdkbskibdisdbbdwjbwdbjhb "+album.getAlbumType() + " " +album.getAlbumId());
       
		String successMessage = userAlbumService.changeAccess(album); 
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
        return response;
    }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
	