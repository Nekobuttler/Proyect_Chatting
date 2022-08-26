
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.Category;
import com.Chatting.Chat.Domain.Community;
import java.util.List;


public interface CategoryService{
    
    public List<Category> getCategories();
       
   public List<Category> getByCategories(String category_name);
   
    public void save(Category category);
    
    public void delete(Category category);
    
    
    public Category getCategory(Category category);
    
    //public Category getByName(Category category);
    
}
