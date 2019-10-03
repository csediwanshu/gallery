package com.codechef.service;

import java.util.List;

import com.codechef.model.Album;

public interface UserAlbumService{
    public String addAlbum(Album album);
    public List<Album> getAlbum(String username);
    public String addLikes(Album album);

}