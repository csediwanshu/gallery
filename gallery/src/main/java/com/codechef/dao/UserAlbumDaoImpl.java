package com.codechef.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.codechef.entity.AlbumEntity;
import com.codechef.entity.UserEntity;
import com.codechef.model.Album;
import org.springframework.stereotype.Repository;

@Repository(value="userAlbumDao")
public class UserAlbumDaoImpl implements UserAlbumDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String addAlbum(Album album)
    {
        UserEntity userEntity=entityManager.find(UserEntity.class,album.getAlbumUser());
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumName(album.getAlbumName());
        albumEntity.setDescription(album.getDescription());
        albumEntity.setLikesCount(0);
        albumEntity.setAlbumType(album.getAlbumType());
        albumEntity.setCoverPhoto(album.getCoverPhoto().getBytes());
        albumEntity.setTimeOfCreation(LocalDateTime.now());
        userEntity.getAlbumEntity().add(albumEntity);
        entityManager.persist(userEntity);
        return "Suceessfully Added Album: " + albumEntity.getAlbumId();
    }

    @Override
    public List<Album> getAlbum(String username){
        // System.out.println("djkbkjdkjbdnwdkwkdkjwdnkjwnddwjknwdjkdwdw"+username);
        UserEntity userEntity = entityManager.find(UserEntity.class, username);
        Set<AlbumEntity> albumEntities=userEntity.getAlbumEntity();
        // System.out.println("djkbkjdkjbdnwdkwkdkjwdnkjwnddwjknwdjkdwdw"+albumEntities.size());

        List<Album> albums=new ArrayList<>();
        for(AlbumEntity albumEntity:albumEntities)
        {
            Album album=new Album();
            album.setAlbumId(albumEntity.getAlbumId());
            album.setAlbumName(albumEntity.getAlbumName());
            album.setDescription(albumEntity.getDescription());
            album.setLikesCount(albumEntity.getLikesCount());
            album.setAlbumType(albumEntity.getAlbumType());
            album.setCoverPhoto(new String(albumEntity.getCoverPhoto()));
            album.setTimeOfCreation(albumEntity.getTimeOfCreation());
            albums.add(album);
           
        }
        // System.out.println("sbhjbhsbhsjhsbhjsbjbsbsbssjhjshbsbjsbjbsjbsjbs"+albums.size());
        return albums;        
}

@Override
public String addLikes(Album album){
    AlbumEntity albumEntity = entityManager.find(AlbumEntity.class,album.getAlbumId());
    
    albumEntity.setLikesCount(album.getLikesCount());

    entityManager.persist(albumEntity);
    return "Suceessfully Increased Likes: " + albumEntity.getAlbumId();
}


@Override
public String removeAlbum(Album album){
    AlbumEntity albumEntity = entityManager.find(AlbumEntity.class,album.getAlbumId());
    entityManager.remove(albumEntity);
    return "Suceessfully Removed Album with Album Name: " + albumEntity.getAlbumName();
}

@Override
public String changeAccess(Album album){
    
    AlbumEntity albumEntity = entityManager.find(AlbumEntity.class,album.getAlbumId());

   if(albumEntity.getAlbumType()==0)
   {
       albumEntity.setAlbumType(1);
   }
   else 
   {
       albumEntity.setAlbumType(0);
   }
   return "Suceessfully Changed  acess with Album Name: " + albumEntity.getAlbumName();
}
}