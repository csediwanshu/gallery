package com.codechef.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.codechef.entity.UserEntity;
import com.codechef.model.User;
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
       userEntity.setProfilePicture(user.getProfilePicture().getBytes());

       entityManager.persist(userEntity);
       return "Suceessfully Added Username: " + user.getUsername();
    }

    @Override
    public User checkLogin(String username ,String password) throws Exception
    {
        // Query query = entityManager.createQuery("select u from UserEntity u where u.username=?1");
        // query.setParameter(1,username);

        UserEntity userEntity = entityManager.find(UserEntity.class, username);
        // System.out.println(userEntity.getUsername());
        // System.out.println(userEntity.getPassword());
        User user= null;
        if(userEntity!=null && userEntity.getPassword().equals(password))
        {
          
            user = new User();
            user.setEmail(userEntity.getEmail());
            user.setFirstName(userEntity.getFirstName());
            user.setGender(userEntity.getGender());
            user.setLastName(userEntity.getLastName());
            user.setProfilePicture(new String(userEntity.getProfilePicture()));
            user.setPassword(userEntity.getPassword());
            user.setUsername(userEntity.getUsername());


        }
        // System.out.println(user.getUsername());
        return user;

    }
}