package com.codechef.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="userPhotoDao")
public class UserPhotoDaoImpl implements UserPhotoDao{

    @Autowired
    private EntityManager entityManager;
    
}