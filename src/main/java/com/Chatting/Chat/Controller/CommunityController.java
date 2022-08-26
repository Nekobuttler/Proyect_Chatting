
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.AmbientService;
import com.Chatting.Chat.Service.CategoryService;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.MembersService;
import com.Chatting.Chat.Service.UserService;
import java.lang.reflect.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@Slf4j
public class CommunityController {
    
    @Autowired
    private CommunityService communityService;
    
     @Autowired
    private UserService userService;
    
     @Autowired 
    private CategoryService categoryService;
   
      @Autowired 
    private AmbientService ambientService;
      
       @Autowired 
    private MembersService membersService;
    
    @GetMapping("/community/new")
    public String newCommunity(Community community){
        return "community/Confi";
    }
     
    
    @GetMapping("community/list")
    public String CommunityData(Model model, User user) {
        var communities = communityService.getCommunities();
        model.addAttribute("communities", communities);
        return "community/list";
   
    }
    
    @PostMapping("/community/save")
    public String saveCommunity(Community community){
       communityService.save(community);
        return "redirect:/started_sesion/User_Main_Page";
                
   }
    /*
    @GetMapping("/community/join/{id_community}")
    public String JoinCommunity(Community community){
        //user= userService.findByUsername(username);
        community=communityService.getCommunity(community);
        community.setUsers(community.getUsers()+1);
        //membersService.Create(user.getId_user(), community.getId_community());
        communityService.save(community);  
        
        return "redirect:/started_sesion/User_Main_Page";
        
    }
    */
    
    @GetMapping("/community/join/{id_community}/{id_user}")
    public String JoinCommunity(Community community, User user, Member member){
        user= userService.getUser(user);
        community=communityService.getCommunity(community);
        community.setUsers(community.getUsers()+1);
        membersService.Create(user.getId_user(), community.getId_community());
        communityService.save(community);  

        return "redirect:/started_sesion/User_Main_Page";
        
    }
    
    
    
        @GetMapping("/community/explore/{id_community}")
    public String ExploreCommunity(Community community, String username , User user,Model model){
       // user= userService.findByUsername(username);
        community=communityService.getCommunity(community);
         var categories= categoryService.getCategories();
         var members= membersService.getMembers();
        var ambients= ambientService.getAmbients();
        var users= userService.getUsers();
        model.addAttribute("community", community);
        model.addAttribute("ambients",ambients);
        model.addAttribute("members",members);
        model.addAttribute("categories",categories);
         model.addAttribute("users",users);
       // community.setUsers(community.getUsers()+1);
        //communityService.save(community);  
        return "started_sesion/Community_Page";
        
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