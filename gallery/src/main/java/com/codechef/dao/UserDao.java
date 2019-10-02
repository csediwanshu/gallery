package com.codechef.dao;

import com.codechef.model.User;

public interface UserDao{

	public String addUser(User user);
    public User checkLogin(String username ,String password) throws Exception;
}