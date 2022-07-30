
package com.Chatting.Chat.Service;

import com.Chatting.Chat.Domain.Ambient;
import com.Chatting.Chat.Domain.Community;
import java.util.List;


public interface CommunityService{
    
   // public List<Community> getCommunities(Ambient ambient);
    
   public List<Community> getCommunities();
   
    public void save(Community community);
    
    public void delete(Community community);
    
    
    public Community getCommunity(Community community);
    
}
