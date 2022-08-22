/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Chatting.Chat.Dao;

import com.Chatting.Chat.Domain.Ambient;
import com.Chatting.Chat.Domain.Category;
import com.Chatting.Chat.Domain.Community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author okk
 */
public interface AmbientRepository extends JpaRepository<Ambient, Long>{
    /*
    @Query("SELECT c FROM Category c WHERE c.id_category = ?1")//Long
    public Category findByIdCategory(String id_category);
    
    @Query("SELECT c FROM Community c WHERE c.id_community = ?1")
    public Community findByIdCommunity(String id_community);
     */
    
}
