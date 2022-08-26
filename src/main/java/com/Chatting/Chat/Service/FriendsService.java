/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.Ambient;

import com.Chatting.Chat.Domain.Friend_request;
import com.Chatting.Chat.Domain.User;
import java.util.List;

public interface FriendsService {
    
    public void send(User user);// recibir un user para buscar su id o username
    /*
    public List<Friend_request> getFriendsRequests2(String username);
    
    public List<Friend_request> getFriendsRequests(String username);
  */
    
    public List<Friend_request> getAllFriendsRequests();
  
    public void save(Friend_request fr);
    
    public void delete(Friend_request fr);
    
    
    public Friend_request getFriend_request(Friend_request fr);
}
