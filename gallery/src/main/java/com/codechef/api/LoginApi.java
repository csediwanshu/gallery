package com.codechef.api;

import java.util.List;

import com.codechef.model.Album;
import com.codechef.model.User;
import com.codechef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin
@RestController     
@RequestMapping("/userAPI")
public class LoginAPI {
    @Autowired
    private UserService userService;


	@PostMapping("registerUser")
	public ResponseEntity<String> addCustomer(@RequestBody User user) throws Exception  {
		try{
        userService.addUser(user);   
		String successMessage = "User added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
		catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
	}

	@PostMapping("checkUser")
	public ResponseEntity<?> checkCustomer(@RequestBody String[] credentials)  {
       try {
		User user=userService.checkLogin(credentials[0],credentials[1]);
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
	   } 
	   catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
	   }
		
	}

	@PostMapping("fetchAllPublicAlbums")
	public ResponseEntity<?> fetchAllPublicAlbums(@RequestBody Integer any)  {
       try {
		List<Album> allAlbums=userService.fetchAllPublicAlbums(any);
		ResponseEntity<List<Album>> response = new ResponseEntity<List<Album>>(allAlbums, HttpStatus.OK);
		return response;
	   } 
	   catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
	   }
		
	}
}