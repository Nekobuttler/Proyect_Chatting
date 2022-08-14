/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Dao.AmbientDao;
import com.Chatting.Chat.Domain.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Chatting.Chat.Domain.Ambient;
import com.Chatting.Chat.Domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Chatting.Chat.Dao.CategoryDao;
import com.Chatting.Chat.Dao.CommunityDao;
import com.Chatting.Chat.Domain.Community;
import org.springframework.data.jpa.repository.Query;


@Service
public class AmbientServiceIMLP implements AmbientService {
    
    @Autowired
    private CommunityDao communityDao;
    
    @Autowired
    private AmbientDao ambientDao;
    
    @Autowired
    private CategoryDao categoryDao;
    
    
    @Transactional(readOnly=true)
    @Override
    public List<Ambient> getAmbients() {
       return (List<Ambient>) ambientDao.findAll();
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Category> getCategories(){
        
         return (List<Category>) categoryDao.findAll();
     }
    
    
    
    
    @Transactional(readOnly=true)
    @Override
    public List<Community> getCommunities(Category category){
        var listAm= getAmbients();
        List <Long> a = null;
        int count = 0;
        if(category!= null){
          listAm.removeIf(e  -> (!e.getId_category().equals(category.getId_category())));
          while(!listAm.isEmpty()){
          a.add(listAm.get(count).getId_community());
          listAm.remove(count);
                  }
          }else{
            
        }
        var listCo= (List<Community>) communityDao.findAllById(a);
        
        
        return listCo;
    }

    

    @Override
    public void save(Ambient ambient) {
        ambientDao.save(ambient);
    }

    @Override
    public void delete(Ambient ambient) {
         ambientDao.delete(ambient);
    }

    @Override
    public Ambient getAmbient(Ambient ambient) {
            return ambientDao.findById(ambient.getId_ambient()).orElse(null);
    }
    
   
    
    
}
