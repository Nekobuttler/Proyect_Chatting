/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Chatting.Chat.Dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceIMLP implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Transactional(readOnly=true)
    @Override
    public List<User> getUsers(){
        return (List<User>) userDao.findAll();
    }
    
    @Transactional
    @Override
    public void delete(User user){
        userDao.delete(user);
    }
    
    
    @Transactional
    @Override
    public void save(User user){
        userDao.save(user);
    }

    
    @Override
    @Transactional(readOnly=true)
    public User getUser(User user){
        return userDao.findById(user.getId_user()).orElse(null);
    }

    
   
    @Override
    @Transactional(readOnly=true)
    public User findByUsername(String username) {
        return ((List<User>) userDao.findByUsername(username)).get(0);
    }

    @Override
    public List<User> getByUsername(String username) {
        return ((List<User>) userDao.getByUsername(username));
    }
    
   
    
    
}
