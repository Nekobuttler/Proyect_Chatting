/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Chatting.Chat.Dao;

import com.Chatting.Chat.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author okk
 */
public interface UserRepository extends JpaRepository<User, Long>{
 @Query("SELECT u FROM User u WHERE u.email = ?1")//Long
    
    public User findByEmail(String email);
    
    
}
