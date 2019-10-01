package com.codechef.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="photoentity")
public class PhotoEntity {

@Id
@Column(name="photoid")
Integer photoId;
@Column(name="description")
String description;
@Column(name="timeofcreation")
LocalDateTime timeOfCreation;
@Column(name="likescount")
Integer likesCount;
@Lob
@Column(name = "photo", columnDefinition="BLOB")
private byte[] photo;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}