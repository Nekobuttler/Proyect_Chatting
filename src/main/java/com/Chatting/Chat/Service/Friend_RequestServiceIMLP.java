/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Chatting.Chat.Domain.Ambient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Chatting.Chat.Dao.FriendsDao;
import com.Chatting.Chat.Dao.UserDao;
import com.Chatting.Chat.Domain.Friend_request;
import com.Chatting.Chat.Domain.User;


@Service
public class Friend_RequestServiceIMLP implements FriendsService {
    
    @Autowired
    private FriendsDao friendsDao;
    
    @Autowired
    private UserDao userDao;

    @Override
    public void send(User user) {
        
    }
    /*
    @Transactional(readOnly=true)
    @Override
    public List<Friend_request> getFriendsRequests(String username) {
        User user=userDao.findByUsername(username);
        return ((List<Friend_request>) friendsDao.getFriendsRequests(user));
    }
     @Transactional(readOnly=true)
     @Override
    public List<Friend_request> getFriendsRequests2(String username) {
        User user=userDao.findByUsername(username);
        return ((List<Friend_request>) friendsDao.getFriendsRequests2(user));
    }
    */
    @Transactional
    @Override
    public void save(Friend_request fr) {
        friendsDao.save(fr);
    }
    @Transactional
    @Override
    public void delete(Friend_request fr) {
        friendsDao.delete(fr);
    }
    
    @Transactional(readOnly=true)
    @Override
    public Friend_request getFriend_request(Friend_request fr) {
         return friendsDao.findById(fr.getId_fr()).orElse(null);
    }

   @Transactional(readOnly=true)
    @Override
    public List<Friend_request> getAllFriendsRequests() {
        return ((List<Friend_request>) friendsDao.findAll());
    }
    
    
    
   

   
   
    
   
    
    
}
