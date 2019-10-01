package com.codechef.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.codechef.entity.UserEntity;
import com.codechef.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    public String addUser(User user)
    {
       UserEntity userEntity = new UserEntity();
       System.out.println(user.getUsername());
       userEntity.setUsername(user.getUsername());
       userEntity.setEmail(user.getEmail());
       userEntity.setFirstName(user.getFirstName());
       userEntity.setLastName(user.getLastName());
       userEntity.setGender(user.getGender());
       userEntity.setPassword(user.getPassword());
       userEntity.setProfilePicture(user.getProfilePicture());

       entityManager.persist(userEntity);
       return "Suceessfully Added Username: " + user.getUsername();
    }
}