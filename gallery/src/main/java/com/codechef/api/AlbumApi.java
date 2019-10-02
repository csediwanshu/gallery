package com.codechef.api;

import java.util.List;

import com.codechef.model.Album;
import com.codechef.service.UserAlbumService;
import com.codechef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController     
@RequestMapping("albumAPI")
public class AlbumApi{
    
    @Autowired
    private UserAlbumService userAlbumService;
    @PostMapping(value="addAlbum")
    public ResponseEntity<?> addAlbum(@RequestBody Album album) throws Exception  {
        userAlbumService.addAlbum(album);   
		String successMessage = "Album added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
    }
    
    @PostMapping(value="getAlbum")
    public ResponseEntity<?> getAlbum(@RequestBody String username) throws Exception  {
        List<Album> albums= userAlbumService.getAlbum(username);   
		String successMessage = "Album added successfully";
		ResponseEntity<List<Album>> response = new ResponseEntity<List<Album>>(albums, HttpStatus.OK);
		return response;
	}
}