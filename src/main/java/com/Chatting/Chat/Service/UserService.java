
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.User;
import java.util.List;


public interface UserService{
    
    public List<User> getUsers();
       
   
    public void save(User user);
    
    public void delete(User user);
    
    
    public User getUser(User user);
    
}
