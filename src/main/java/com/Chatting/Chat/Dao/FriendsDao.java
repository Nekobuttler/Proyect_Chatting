
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.Friend_request;
import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface FriendsDao extends JpaRepository<Friend_request, Long>{
    
    //Get friend request send to users 
    //@Query(value="SELECT f FROM friend_request f WHERE f.id_suser = ?1.id_user AND f.state != true")
    //public List<Friend_request> getFriendsRequests(User user);
  
    //Get friends that accept the friend request   |||| this will be with thymeleaf in html
    
    //Get recieved friend_requets
    //@Query(value="SELECT f FROM friend_request f WHERE f.id_ruser = ?1.id_user AND f.state != true")
    //public List<Friend_request> getFriendsRequests2(User user);
     
     
}
