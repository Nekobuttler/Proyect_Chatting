/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat;


import com.Chatting.Chat.Dao.UserRepository;
import com.Chatting.Chat.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService{
    
        @Autowired
        UserRepository userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String email){
        User user = userRepo.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
           
    }