
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
    

    @GetMapping("/SeeData")
    public String dataVisualization(Model model) {
        var users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
       
    }
    
    @PostMapping("/saveUser")
    public String saveUser(User user){
       userService.save(user);
        return "redirect:/";
                
   }
    
    @GetMapping("/ProfileData")
    public String DataUser(User user){
        userService.getUser(user);
        return "";
            }
    
     // @GetMapping("/")
    //public String modificarArticulo(Model model){
        
    //    var articulos= artService.getArticulos();
   //     model.addAttribute("articulos", articulos);
        
  //      return "index";
                
  //  }
    
    @GetMapping("/eliminarUser/{id_user}")
    public String deleteUser(User user){
       userService.delete(user);
        
        return "redirect:/";
          }
    
    
    @GetMapping("/Log_in/{id_user}")
    public String log_user(User user){
     
        
        return "/started_sesion/User-Page";
          }
}