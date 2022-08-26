
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    
     @GetMapping("/user/new")
    public String newUser(User user){
        return "user/Confi";
    }
    

    @GetMapping("user/list")
    public String dataVisualization(Model model) {
        var users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/list";
       
    }
    
    @PostMapping("/user/save")
    public String saveUser(User user){
       userService.save(user);
        return "redirect:/user/list";
                
   }
    
    @GetMapping("/ProfileData")
    public String DataUser(User user){
        userService.getUser(user);
        return "";
            }
    
     
    
    @GetMapping("/user/erase/{id_user}")
    public String deleteUser(User user){
       userService.delete(user);
        
        return "redirect:/user/list";
          }
    
    
    
    
      @GetMapping("/user/Confi/{id_user}")
    public String ConfiUser(Model model, User user){
        
        user= userService.getUser(user);
        model.addAttribute("user", user);
        
        return "user/Confi";

   }
    
    
    @GetMapping("/Log_in/{id_user}")
    public String log_user(User user){
     
        
        return "/user/list";
          }
    
     
    @PostMapping("/user/search")
    public String searchUser(User user, Model model){
        var users=userService.getByUsername(user.getUsername());
        if(user!= null){
            model.addAttribute("users",users);
            return "user/result";
        }else{
            return "user/result";
        }
    }
}