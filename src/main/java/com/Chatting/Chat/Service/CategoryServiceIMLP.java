/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Dao.AmbientDao;
import com.Chatting.Chat.Domain.Categories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Chatting.Chat.Dao.CategoriesDao;
import com.Chatting.Chat.Domain.Ambient;
import com.Chatting.Chat.Domain.Categories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryServiceIMLP implements CategoriesService {
    
    @Autowired
    private CategoriesDao categoryDao;
    
    @Autowired
    private AmbientDao ambientDao;
    
    @Transactional(readOnly=true)
    @Override
    public List<Categories> getCategories(){
        return (List<Categories>) categoryDao.findAll();
    }
    
    @Transactional
    @Override
    public void delete(Categories category){
        categoryDao.delete(category);
    }
    
    
    @Transactional
    @Override
    public void save(Categories category){
        Ambient ambient = category.g;
        ambient=ambientDao.save(ambient);
        category.setAmbient(ambient);
        categoryDao.save(category);
    }

    
    @Override
    @Transactional(readOnly=true)
    public Categories getCategory(Categories category){
        return categoryDao.findById(category.getId_category()).orElse(null);
    }
    
   
    
    
}
