package com.codechef.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.codechef.entity.AlbumEntity;
import com.codechef.entity.UserEntity;
import com.codechef.model.Album;
import com.codechef.model.User;
import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    public String addUser(User user)
    {
       UserEntity userEntity = new UserEntity();
       System.out.println(user.getUsername());
       userEntity.setUsername(user.getUsername());
       userEntity.setEmail(user.getEmail());
       userEntity.setFirstName(user.getFirstName());
       userEntity.setLastName(user.getLastName());
       userEntity.setGender(user.getGender());
       userEntity.setPassword(user.getPassword());
       userEntity.setProfilePicture(user.getProfilePicture().getBytes());

    //    AlbumEntity albumEntity = new AlbumEntity();
    //    albumEntity.setAlbumName("unnamedAlbum");
    //    Set<AlbumEntity> albumEntities = new HashSet<AlbumEntity>();
    //    albumEntities.add(albumEntity);
    //    userEntity.setAlbumEntity(albumEntities);
       entityManager.persist(userEntity);
       return "Suceessfully Added Username: " + user.getUsername();
    }

    @Override
    public User checkLogin(String username ,String password) throws Exception
    {

        UserEntity userEntity = entityManager.find(UserEntity.class, username);
        // System.out.println(userEntity.getUsername());
        // System.out.println(userEntity.getPassword());
        User user= null;
        if(userEntity!=null && userEntity.getPassword().equals(password))
        {
          
            user = new User();
            user.setEmail(userEntity.getEmail());
            user.setFirstName(userEntity.getFirstName());
            user.setGender(userEntity.getGender());
            user.setLastName(userEntity.getLastName());
            user.setProfilePicture(new String(userEntity.getProfilePicture()));
            user.setPassword(userEntity.getPassword());
            user.setUsername(userEntity.getUsername());


        }
        // System.out.println(user.getUsername());
        return user;

    }

    @Override
    public List<Album> fetchAllPublicAlbums(Integer any) throws Exception{
        System.out.println("abbabksbkjsnksknsknssnsskjsnjks"+any);
        Query query=entityManager.createQuery("select a from AlbumEntity a where a.albumType=?1");
        query.setParameter(1, any);
        List<AlbumEntity> albumEntities=query.getResultList();
        System.out.println("ahbhjabbabbabababahhbahbahbahaba+"+albumEntities.size());
        List<Album> albums=new ArrayList<Album>();

        for(AlbumEntity albumEntity:albumEntities){
            Album album = new Album();
            album.setAlbumId(albumEntity.getAlbumId());
            album.setAlbumName(albumEntity.getAlbumName());
            album.setDescription(albumEntity.getDescription());
            album.setLikesCount(albumEntity.getLikesCount());
            album.setAlbumType(albumEntity.getAlbumType());
            album.setCoverPhoto(new String(albumEntity.getCoverPhoto()));
            album.setTimeOfCreation(albumEntity.getTimeOfCreation());
            albums.add(album);
        }
        return albums;
    }
}