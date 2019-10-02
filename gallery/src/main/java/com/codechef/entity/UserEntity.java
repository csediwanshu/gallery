package com.codechef.entity;
import java.io.File;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userentity")
public class UserEntity {
    @Id
    @Column(name="username")
    String username;
    @Column(name="firstname")
    String firstName;
    @Column(name="lastname")
    String lastName;
    @Column(name="email")
    String email;
    @Column(name="gender")
    String gender;

@Lob
@Column(name = "profilepicture", columnDefinition="LONGBLOB")
byte[] profilePicture;
    @Column(name="password")
    String password;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="username")
    Set<AlbumEntity> albumEntity;

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public Set<AlbumEntity> getAlbumEntity() {
        return albumEntity;
    }

    public void setAlbumEntity(Set<AlbumEntity> albumEntity) {
        this.albumEntity = albumEntity;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    

    


}