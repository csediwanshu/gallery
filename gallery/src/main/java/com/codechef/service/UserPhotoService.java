package com.codechef.service;

import java.util.List;

import com.codechef.model.Photo;

public interface UserPhotoService{
    public List<Photo> getImages(Integer albuId) throws Exception;
    public String addPhoto(Photo photo) throws Exception;
    public String addLikes(Photo photo) throws Exception;
    public String removePhoto(Photo photo) throws Exception;
}