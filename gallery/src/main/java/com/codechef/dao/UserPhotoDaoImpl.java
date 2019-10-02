package com.codechef.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.codechef.entity.PhotoEntity;
import com.codechef.entity.UserEntity;
import com.codechef.model.Photo;
import com.codechef.model.User;


import org.springframework.stereotype.Repository;

@Repository(value="userPhotoDao")
public class UserPhotoDaoImpl implements UserPhotoDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Photo> getImages(User user) throws Exception{
        Query query=  entityManager.createQuery("select * from userentity u where u.username=?1 ");
        query.setParameter(1,user.getUsername());
        
        UserEntity userEntity= (UserEntity) query.getResultList();
       

        // List<Photo> photos2=new ArrayList<Photo>();
        // for(PhotoEntity p:photos){
        //     Photo photo= new Photo();

        //     photo.setDescription(p.getDescription());
        //     photo.setPhotoId(p.getPhotoId());
        //     photo.setPhotoData(p.getPhotoData());
        //     photo.setLikesCount(p.getLikesCount());
        //     photo.setTimeOfCreation(p.getTimeOfCreation());
        //    photos2.add(photo);
        // }
        return null;

    }

    @Override
    public String addPhoto(Photo photo) throws Exception{
        PhotoEntity photoEntity=new PhotoEntity();
        photoEntity.setDescription(photo.getDescription());
        photoEntity.setLikesCount(photo.getLikesCount());
        photoEntity.setPhotoData(photo.getPhotoData());
        photoEntity.setTimeOfCreation(LocalDateTime.now());
        entityManager.persist(photoEntity);
        return "Succesfully Added Image" + photoEntity.getPhotoId();
    }



}