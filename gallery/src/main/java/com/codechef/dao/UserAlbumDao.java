package com.codechef.dao;

import java.util.List;

import com.codechef.model.Album;

public interface UserAlbumDao{

public String addAlbum(Album album);
public List<Album> getAlbum(String username);
public String addLikes(Album album);
public String removeAlbum(Album album);

}