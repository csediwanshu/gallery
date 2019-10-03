package com.codechef.service;

import java.util.List;

import javax.transaction.Transactional;

import com.codechef.dao.UserPhotoDao;
import com.codechef.model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service(value="userPhotoService")
@Transactional
public class UserPhotoServiceImpl implements UserPhotoService{
    
    @Autowired
    private UserPhotoDao userPhotoDao;

    @Override
    public List<Photo> getImages(Integer albumId) throws Exception{
        return userPhotoDao.getImages(albumId);
    }

    @Override
    public String addPhoto(Photo photo) throws Exception{

        return userPhotoDao.addPhoto(photo);
    }

    @Override
    public String addLikes(Photo photo) throws Exception{

        return userPhotoDao.addLikes(photo);
    }

    @Override
    public String removePhoto(Photo photo) throws Exception{

        return userPhotoDao.removePhoto(photo);
    }

}