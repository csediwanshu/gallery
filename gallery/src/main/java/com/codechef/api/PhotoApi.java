package com.codechef.api;

import java.util.ArrayList;
import java.util.List;

import com.codechef.model.Photo;
import com.codechef.model.User;
import com.codechef.service.UserPhotoService;

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
@RequestMapping("/photoAPI")
public class PhotoApi{

    @Autowired
    private UserPhotoService userPhotoService;
    @PostMapping(value="/getPhoto")
    ResponseEntity<?> getImages(@RequestBody User user) throws Exception{

        try{
            List<Photo> photoList=new ArrayList<Photo>();
            photoList=userPhotoService.getImages(user);
            ResponseEntity<List<Photo>> response = new ResponseEntity<List<Photo>>(photoList, HttpStatus.OK);
            return response;

        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping(value="/addPhoto")
    ResponseEntity<?> addImage(@RequestBody Photo photo) throws Exception{

        try{
            String message=userPhotoService.addPhoto(photo);
            ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.OK);
            return response;

        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    
    
}