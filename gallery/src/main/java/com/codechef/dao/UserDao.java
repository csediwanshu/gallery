package com.codechef.dao;

import java.util.List;

import com.codechef.model.Album;
import com.codechef.model.User;

public interface UserDao{

	public String addUser(User user);
    public User checkLogin(String username ,String password) throws Exception;
    public List<Album> fetchAllPublicAlbums(Integer any) throws Exception;

}