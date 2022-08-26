
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.Domain.Friend_request;
import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.FriendsService;
import com.Chatting.Chat.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class FriendsController {
    
    @Autowired
    private UserService userService;
    
     @Autowired
    private FriendsService friendsService;
    
    
    @GetMapping("fr/list")
    public String dataVisualization(Model model) {
        var frs = friendsService.getAllFriendsRequests();
        model.addAttribute("frs", frs);
        return "fr/list";
       
    }
    
    @PostMapping("/fr/save")
    public String saveFR(Friend_request fr){
        friendsService.save(fr);
        return "redirect:/fr/list";
                
   }
  
    
    @GetMapping("/fr/erase/{id_friend_request}")
    public String deleteFR(Friend_request fr){
        friendsService.delete(fr);
        
        return "redirect:/fr/list";
          }

    
   @PostMapping("/fr/send/{id_user}+{username}")
     public String send(Friend_request fr , String username, User ruser){
         User suser= userService.findByUsername(username);
         ruser = userService.getUser(ruser);
         fr.setRuser(ruser.getId_user());
         fr.setSuser(suser.getId_user());
         fr.setState(false);
         friendsService.save(fr);
         return "redirect:/started_sesion/Profile";
     }
}