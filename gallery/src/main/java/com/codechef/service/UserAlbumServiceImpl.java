package com.codechef.service;

import java.util.List;

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

    @Override
    public String addAlbum(Album album){
        return userAlbumDao.addAlbum(album);  
    }

    @Override
    public List<Album> getAlbum(String username){
return userAlbumDao.getAlbum(username);
    }

}