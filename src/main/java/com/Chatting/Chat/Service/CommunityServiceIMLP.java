/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Dao.AmbientDao;
import com.Chatting.Chat.Domain.Community;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Chatting.Chat.Dao.CommunityDao;
import com.Chatting.Chat.Domain.Ambient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommunityServiceIMLP implements CommunityService {
    
    @Autowired
    private CommunityDao communityDao;
    
    @Autowired
    private AmbientDao ambientDao;
    /*
    @Transactional(readOnly=true)
    @Override
    public List<Community> getCommunities(Ambient ambient){
        var list= (List<Community>) communityDao.findAll();
        if(ambient!= null){
          list.removeIf(e  -> (!e.getAmbient().getId_category().equals(ambient.getId_category())));
            
        }
        return list;
    }
*/
    
    @Transactional(readOnly=true)
    @Override
    public List<Community> getCommunities(){
        return (List<Community>) communityDao.findAll();
    }
    
    @Transactional
    @Override
    public void delete(Community community){
        communityDao.delete(community);
    }
    
    
    @Transactional
    @Override
    public void save(Community community){
        //Ambient ambient = community.getAmbient();
       // ambient=ambientDao.save(ambient);
        //community.setAmbient(ambient);
        communityDao.save(community);
    }

    
    @Override
    @Transactional(readOnly=true)
    public Community getCommunity(Community community){
        return communityDao.findById(community.getId_community()).orElse(null);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Community getByCommunity_name(Community community) {
        return ((List<Community>) communityDao.findByCommunity_name(community.getCommunity_name())).get(0);
    }
 
    
}
