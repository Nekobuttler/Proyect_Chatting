
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.Category;
import java.util.List;


public interface CategoryService{
    
    public List<Category> getCategories();
       
   
    public void save(Category category);
    
    public void delete(Category category);
    
    
    public Category getCategory(Category category);
    
    //public Category getByName(Category category);
    
}
