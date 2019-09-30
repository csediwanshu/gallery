package com.codechef.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;

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

}