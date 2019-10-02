package com.codechef.api;

import com.codechef.model.User;
import com.codechef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
		System.out.println();
        userService.addUser(user);   
		String successMessage = "User added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}

	@PostMapping("checkUser")
	public ResponseEntity<?> checkCustomer(@RequestBody String[] credentials) throws Exception  {
       
		String successMessage = "User added successfully";
		User user=null;
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
	}
}