
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
    

    @GetMapping("/CommunityData")
    public String CommunityData(Model model) {
        var communities = communityService.getCommunities();
        model.addAttribute("communities", communities);
        return "User-Page";
       
    }
    
    @PostMapping("/saveCommunity")
    public String saveCommunity(Community community){
       communityService.save(community);
        return "redirect:/";
                
   }
    
    
    
     // @GetMapping("/")
    //public String modificarArticulo(Model model){
        
    //    var articulos= artService.getArticulos();
   //     model.addAttribute("articulos", articulos);
        
  //      return "index";
                
  //  }
    
    @GetMapping("/eliminarCommunity/{id_community}")
    public String deleteCommunity(Community community){
       communityService.delete(community);
        
        return "redirect:/";
          }
    
    
    
}