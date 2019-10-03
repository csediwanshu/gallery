package com.codechef.service;

import java.util.List;

import com.codechef.dao.UserDao;
import com.codechef.model.Album;
import com.codechef.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public String addUser(User user)
    {
        return userDao.addUser(user);    
    }

    @Override
    public User checkLogin(String username ,String password) throws Exception
    {
        User user = userDao.checkLogin(username,password);
        if (user == null) {
            throw new Exception("NO_USER_FOUND");
        }
        return user;
    }

    @Override
    public List<Album> fetchAllPublicAlbums(Integer any) throws Exception{
        return userDao.fetchAllPublicAlbums(any);
    }

}