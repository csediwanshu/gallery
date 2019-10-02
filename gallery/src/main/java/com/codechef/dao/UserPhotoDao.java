package com.codechef.dao;

import java.util.List;

import com.codechef.model.Photo;
import com.codechef.model.User;

public interface UserPhotoDao{

    public List<Photo> getImages(User user) throws Exception;

    public String addPhoto(Photo photo) throws Exception;
}