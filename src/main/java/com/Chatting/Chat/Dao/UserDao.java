
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends JpaRepository<User, Long>{
    
    @Query("SELECT u FROM users u WHERE u.username = ?1")
    public User findByUsername(String user);
    
    @Query("SELECT u FROM users u WHERE u.username like %?1%")//Long
    public List<User> getByUsername(String username);
}
