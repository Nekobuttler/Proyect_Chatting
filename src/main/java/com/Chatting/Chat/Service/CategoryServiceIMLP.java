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
import com.Chatting.Chat.Domain.Community;


@Service
public class CategoryServiceIMLP implements CategoryService {
    
    @Autowired
    private CategoryDao categoryDao;
    
    
    
    @Transactional(readOnly=true)
    @Override
    public List<Category> getCategories(){
        return (List<Category>) categoryDao.findAll();
    }
    
    @Transactional
    @Override
    public void delete(Category category){
        categoryDao.delete(category);
    }
    
    
    @Transactional
    @Override
    public void save(Category category){
        
        categoryDao.save(category);
    }

    
    @Override
    @Transactional(readOnly=true)
    public Category getCategory(Category category){
        return categoryDao.findById(category.getId_category()).orElse(null);
    }
    
    /* 
    @Override
    @Transactional(readOnly=true)
    public Category getByName(Category category){
         return (List<Category>) categoryDao.f
    }
    */
    @Transactional(readOnly=true)
    @Override
    public List<Category> getByCategories(String category_name) {
        return (List<Category>) categoryDao.findAll();
    }


   
   
    
   
    
    
}
