package com.codechef.service;

import com.codechef.model.Photo;
import com.codechef.model.User;


public interface UserService{
    public String addUser(User user) throws Exception;
    public User checkLogin(String username ,String password) throws Exception;
    
}