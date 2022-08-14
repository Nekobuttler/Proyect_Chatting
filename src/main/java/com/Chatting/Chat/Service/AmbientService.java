/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.Ambient;
import com.Chatting.Chat.Domain.Category;
import com.Chatting.Chat.Domain.Community;
import java.util.List;

public interface AmbientService {
    
    public List<Category> getCategories();
    
    public List<Ambient> getAmbients();
    
    public List<Community> getCommunities(Category category);
    
     
    public void save(Ambient ambient);
    
    public void delete(Ambient ambient);
    
    
    public Ambient getAmbient(Ambient ambient);
}
