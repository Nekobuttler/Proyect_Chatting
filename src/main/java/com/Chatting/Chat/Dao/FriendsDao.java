
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.Members;
import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface FriendsDao extends CrudRepository<Members, Long>{
    
    
     
     
}
