
package com.Chatting.Chat.Service;


import com.Chatting.Chat.Domain.Item;
import java.util.ArrayList;
import java.util.List;


public interface ItemService{
    
   //public List<Community> getCommunities(Ambient ambient);
    public List<Item> listItems = new ArrayList<>();
    
            
   public List<Item> getItems();
   
   
    public void save(Item item);
    
    public void delete(Item item);
    
    
    public Item getItem(Item item);
    
    public void actualiza(Item item);
    
     public void facturar();
    
}
