package com.codechef.service;

import javax.transaction.Transactional;

import com.codechef.dao.UserAlbumDao;
import com.codechef.model.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userAlbumService")
@Transactional
public class UserAlbumServiceImpl implements UserAlbumService{
    @Autowired
    private UserAlbumDao userAlbumDao;
    public String addAlbum(Album album){
        return userAlbumDao.addAlbum(album);
        
    }
}