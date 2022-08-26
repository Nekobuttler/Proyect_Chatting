
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.Members;
import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface MembersDao extends JpaRepository<Members, Long>{
    
  /*  
     @Query(
            value= "SELECT users.username FROM community,members,users WHERE community.id_community = ?1.id_community AND community.id_community = members.id_community AND "
            + "members.id_user = users.id_user " ,
            nativeQuery = true
    )
    public List<User> getUsers(Community community);//se obtiene la id de la comunidad, se a;aden a una lista todos los usuario encontrados en miembros con ese id de comunidad 
    */

    /*
    @Query(
          value= "SELECT c FROM members,users,community c WHERE (:username = users.username) AND (users.id_user = members.id_user) AND" +
            "(members.id_community = c.id_community)")
   public List<Community> getCommunities(@Param("username")String username);//se obtiene la id del usuario actual, se a;aden a una lista todos las comunidades
                                                                        //encontrados en miembros con ese id del usuario y obtner aquellos a las que se ha unido 
    */
    
     //public List<Community> findByUser(User user);
     
}
