
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class CommunityController {
    
    @Autowired
    private CommunityService communityService;
    
    
    
    
    
    @GetMapping("/community/new")
    public String newCommunity(Community community){
        return "community/Confi";
    }
     
    
    @GetMapping("community/list")
    public String CommunityData(Model model) {
        var communities = communityService.getCommunities();
        model.addAttribute("communities", communities);
        return "community/list";
   
    }
    
    @PostMapping("/community/save")
    public String saveCommunity(Community community){
       communityService.save(community);
        return "redirect:/community/list";
                
   }
    
    
    
      @GetMapping("/community/Confi/{id_community}")
    public String ConfiCommunity(Model model, Community community){
        
        community= communityService.getCommunity(community);
        model.addAttribute("community", community);
        
        return "community/Confi";

   }
    
    @GetMapping("/community/erase/{id_community}")
    public String deleteCommunity(Community community){
       communityService.delete(community);
        
        return "redirect:/community/list";
          }
    
    
    
}