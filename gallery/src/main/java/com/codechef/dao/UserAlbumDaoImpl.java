package com.codechef.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import com.codechef.entity.AlbumEntity;
import com.codechef.model.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="userAlbumDao")
public class UserAlbumDaoImpl implements UserAlbumDao{

    @Autowired
    private EntityManager entityManager;

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

    
}