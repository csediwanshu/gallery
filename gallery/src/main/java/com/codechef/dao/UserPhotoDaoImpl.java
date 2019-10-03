package com.codechef.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.codechef.entity.AlbumEntity;
import com.codechef.entity.PhotoEntity;
import com.codechef.model.Photo;


import org.springframework.stereotype.Repository;

@Repository(value="userPhotoDao")
public class UserPhotoDaoImpl implements UserPhotoDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Photo> getImages(Integer albumId) throws Exception{
       AlbumEntity albumEntity =entityManager.find(AlbumEntity.class,albumId);
        
        Set<PhotoEntity> photos=albumEntity.getPhotoEntity();
        List<Photo> photos2=new ArrayList<Photo>();
        if(photos2!=null){
         for(PhotoEntity p:photos){
            Photo photo= new Photo();
            photo.setDescription(p.getDescription());
            photo.setPhotoId(p.getPhotoId());
            photo.setPhotoData(new String(p.getPhotoData()));
            photo.setPhotoType(p.getPhotoType());
            photo.setLikesCount(p.getLikesCount());
            photo.setTimeOfCreation(p.getTimeOfCreation());
           photos2.add(photo);
         }
        }
        return photos2;

    }

    @Override
    public String addPhoto(Photo photo) throws Exception{
        AlbumEntity albumEntity=entityManager.find(AlbumEntity.class,photo.getPhotoAlbumId());
        PhotoEntity photoEntity=new PhotoEntity();
        photoEntity.setDescription(photo.getDescription());
        photoEntity.setLikesCount(0);
        photoEntity.setPhotoData(photo.getPhotoData().getBytes());
        photoEntity.setPhotoType(photo.getPhotoType());
        photoEntity.setTimeOfCreation(LocalDateTime.now());
       if(albumEntity.getPhotoEntity()!=null){
           albumEntity.getPhotoEntity().add(photoEntity);
       }
       else {
           Set<PhotoEntity> entities=new HashSet<PhotoEntity>();
           entities.add(photoEntity);
           albumEntity.setPhotoEntity(entities);
       }
       System.out.println("dhuefbvueuybebnefadineadefjnefdi"+photoEntity.getPhotoId());
        entityManager.persist(albumEntity);
        return "Succesfully Added Image" + photoEntity.getPhotoId();
    }
    @Override
    public String addLikes(Photo photo) throws Exception{
       PhotoEntity photoEntity=entityManager.find(PhotoEntity.class,photo.getPhotoId());
       photoEntity.setLikesCount(photo.getLikesCount());
       entityManager.persist(photoEntity);
        return "Succesfully Added Image" + photoEntity.getPhotoId();
    }

    @Override
    public String removePhoto(Photo photo) throws Exception{
       PhotoEntity photoEntity=entityManager.find(PhotoEntity.class,photo.getPhotoId());
       entityManager.remove(photoEntity);
        return "Succesfully Remove Image with ImageId" + photoEntity.getPhotoId();
    }

    @Override
    public String changeAccess(Photo photo) throws Exception{
       PhotoEntity photoEntity=entityManager.find(PhotoEntity.class,photo.getPhotoId());
       if(photoEntity.getPhotoType()==1)
       {photoEntity.setPhotoType(0);}
       else 
       {photoEntity.setPhotoType(1);}
        return "Succesfully Change Acess with ImageId" + photoEntity.getPhotoId();
    }



}