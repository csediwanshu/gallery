package com.codechef.service;

import java.util.List;

import com.codechef.model.Album;
import com.codechef.model.User;


public interface UserService{
    public String addUser(User user) throws Exception;
    public User checkLogin(String username ,String password) throws Exception;
    public List<Album> fetchAllPublicAlbums(Integer any) throws Exception;
    
}