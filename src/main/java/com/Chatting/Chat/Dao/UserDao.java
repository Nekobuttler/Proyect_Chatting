
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long>{
    
    public User findByUsername(String user);
}
