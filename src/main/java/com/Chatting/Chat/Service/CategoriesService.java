
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.Categories;
import java.util.List;


public interface CategoriesService{
    
    public List<Categories> getCategories();
       
   
    public void save(Categories categories);
    
    public void delete(Categories categories);
    
    
    public Categories getCategories(Categories categories);
    
}
