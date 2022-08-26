
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends JpaRepository<Category, Long>{
    
   // @Query("SELECT c FROM category c WHERE c.category_name like %?1%")//Long
  //  public List<Category> getByCategory(String category_name);
}
