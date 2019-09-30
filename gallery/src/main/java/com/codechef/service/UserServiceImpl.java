package com.codechef.service;

import com.codechef.dao.UserDao;
import com.codechef.model.User;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public String addUser(User user)
    {
        return userDao.addUser(user);    
    }

}