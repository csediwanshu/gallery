package com.codechef.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.codechef.entity.AlbumEntity;
import com.codechef.entity.UserEntity;
import com.codechef.model.Album;
import com.codechef.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="userAlbumDao")
public class UserAlbumDaoImpl implements UserAlbumDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public String addAlbum(Album album)
    {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumName(album.getAlbumName());
        albumEntity.setDescription(album.getDescription());
        albumEntity.setLikesCount(0);
        albumEntity.setTimeOfCreation(LocalDateTime.now());
        entityManager.persist(albumEntity);
        return "Suceessfully Added Album: " + album.getAlbumId();
    }

    @Override
    public List<Album> getAlbum(String username){
        Query query=entityManager.createQuery("select u form userentity u where u.username=?1");
        query.setParameter(1, username);
        UserEntity userEntity = (UserEntity) query.getSingleResult();

        Set<AlbumEntity> albumEntities=userEntity.getAlbumEntity();
         
        List<Album> albums=new ArrayList<>();
        for(AlbumEntity albumEntity:albumEntities)
        {
            Album album=new Album();
            album.setAlbumId(albumEntity.getAlbumId());
            album.setAlbumName(albumEntity.getAlbumName());
            album.setDescription(albumEntity.getDescription());
            album.setLikesCount(albumEntity.getLikesCount());
            album.setTimeOfCreation(albumEntity.getTimeOfCreation());
           
        }
        return albums;        
}

}