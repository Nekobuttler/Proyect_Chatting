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
import com.Chatting.Chat.Dao.CommunityDao;
import com.Chatting.Chat.Dao.MembersDao;
import com.Chatting.Chat.Dao.UserDao;
import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.Members;
import com.Chatting.Chat.Domain.User;
import org.springframework.data.jpa.repository.Query;


@Service
public class MembersServiceIMLP implements MembersService {

    @Autowired
    private CommunityDao communityDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private MembersDao membersDao;
    
    @Override
    public List<Members> getMembers() {
        return (List<Members>)membersDao.findAll();
    }
/*
    @Override
    public List<User> getUsers(Community community) {
        
    }

    @Override
    public List<Community> getCommunities(User user) {
        var listM = getMembers();
        listM.removeIf(e -> !e.getId_user().equals(user.getId_user()));
        var listC = (List <Community>) communityDao.findAll();
        //return communityDao.findAllById(listM.forEach   )
        //listC.retainAll()
       
    }
*/
    @Override
    public void save(Members members) {
        membersDao.save(members);
    }

    @Override
    public void delete(Members members) {
        membersDao.delete(members);
    }

    @Override
    public Members getMember(Members members) {
        return membersDao.findById(members.getId_members()).orElse(null);
    }

   

    @Override
    public List<Community> getCommunities(String user) {
        
        return (List<Community>) membersDao.getCommunities(user);
    }

    @Override
    public List<User> getUsers(Community community) {
        return (List<User>) membersDao.getUsers(community);
    }
    
  
}
