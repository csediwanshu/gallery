package com.codechef.entity;


import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="albumentity")
public class AlbumEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="albumid")
    Integer albumId;
    @Column(name="albumname")
    String albumName;
    @Column(name="description")
    String description;
    @Column(name="coverphoto")
    String coverPhoto;
    @Column(name="timeofcreation")
    LocalDateTime timeOfCreation;
    @Column(name="likescount")
    Integer likesCount;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="albumid")
    Set<PhotoEntity> photoEntity;


    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

   

    public Set<PhotoEntity> getPhotoEntity() {
        return photoEntity;
    }

    public void setPhotoEntity(Set<PhotoEntity> photoEntity) {
        this.photoEntity = photoEntity;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    
}

