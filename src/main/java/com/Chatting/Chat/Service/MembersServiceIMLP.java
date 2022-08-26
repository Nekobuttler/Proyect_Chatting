/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;

import com.Chatting.Chat.CustomUserDetails;
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
import com.Chatting.Chat.Dao.MembersDao;
import com.Chatting.Chat.Dao.UserDao;
import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.Members;
import com.Chatting.Chat.Domain.User;
import java.util.Objects;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@Service
public class MembersServiceIMLP implements MembersService {

    @Autowired
    private CommunityDao communityDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private MembersDao membersDao;
   
    //@Autowired 
    //private CustomUserDetails userdeta;
    
   // Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   
    
    @Transactional(readOnly=true)
    @Override
    public List<Members> getMembers() {
        return (List<Members>)membersDao.findAll();
    }
    
    
/*
    @Override
    public List<Community> getCommunities2(String user) {
        //user=((UserDetails)principal).getUsername();
        var Obuser=userDao.findByUsername(user);
        var listM = getMembers();
        listM.removeIf(e -> !e.getUser().getId_user().equals(Obuser.getId_user()));
        var listC = (List <Community>) communityDao.findAll();
        var finallist= (List <Community>) null;
        for( var a:listC ){
            for(var b:listM){
                if(Objects.equals(a.getId_community(), b.getCommunity().getId_community()))
                    finallist.add(a);
            }
        }
        return finallist;
       
    }
    */
    /*
    @Transactional(readOnly=true)
    @Override
    public List<Community> getCommunities2(String username) {
        //user=((UserDetails)principal).getUsername();
        //user=userdeta.getUsername();
       var Obuser=userDao.findByUsername(username);
        return ((List<Community>) membersDao.findByUser(Obuser));
      // return ((List<Community>) membersDao.getCommunities(username));
       
    }
    */
    
    
    @Transactional
    @Override
    public void save(Members members) {
        membersDao.save(members);
    }

    @Transactional
    @Override
    public void delete(Members members) {
        membersDao.delete(members);
    }
    
    @Transactional(readOnly=true)
    @Override
    public Members getMember(Members members) {
        return membersDao.findById(members.getId_member()).orElse(null);
    }
/*
   
    @Transactional(readOnly=true)
    @Override
    public List<Community> getCommunities(String user) {
        List<Community> list = membersDao.getCommunities(user);
        return list;
    }
    
    
    @Transactional(readOnly=true)
    @Override
    public List<User> getUsers(Community community) {
        
        return (List<User>) membersDao.getUsers(community);
    }
  */
    @Transactional
    @Override
    public void Create(Long user, Long community) {
        Members member = null;
        member.setId_community(community);
        member.setId_user(user);
        membersDao.save(member);
    }

  
    
    
  
}
