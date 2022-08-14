
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService{
    
    @Query(value= "SELECT u FROM USER WHERE u.username LIKE %?1%")
    List<User> findByUsernameContaining(String username);
    
    public List<User> getUsers();
       
   
    public void save(User user);
    
    public void delete(User user);
    
    
    public User getUser(User user);
    
    
    
}
