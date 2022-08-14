
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.MembersService;
import com.Chatting.Chat.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j

public class IndexController {
    
    
    @Autowired
    private CommunityService communityService;
    @Autowired
    private UserService userService;
    @Autowired
    private MembersService memberService;
    
    
    @GetMapping("/")
    public String start(){
        //var communities = communityService.getCommunities();
        //model.addAttribute("communities", communities);
        
        //return "/started_sesion/User_Main_Page";
        return "Main_Page";
    }
    
    @GetMapping("sign_in")
    public String Sign_in(Model model){
        model.addAttribute("user", new User());
        return "Sign_in";
    }
    

    
    @GetMapping("Userlogin")
    public String Login(Model model){
        return "login";
    }
    
    @PostMapping("/Data_recolectation")   
    public String Registration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);
        return "Main_Page";
    }
    
    @GetMapping("/started_sesion/Profile")
    public String ProfileUser(Model model, User user){
        user = userService.getUser(user);
        model.addAttribute("user", user);
        
        return "/started_sesion/Profile";
    }
    
    public String getUser() {
    //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //String a =((UserDetails)principal).getUsername();
    //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
   // String currentPrincipalName = authentication.getName()
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
        
    };
    
   // public String currentUserName(Authentication authentication) {
    //    return authentication.getName();
  //  }
    
    @GetMapping("/started_sesion/User_Main_Page")
    public String MyCommunities(String user, Model model){           //change methodology seacrh by name and not id or user
       user=getUser();
        var communities = memberService.getCommunities(user);
        model.addAttribute("communities",communities);
        return "/started_sesion/User_Main_Page";
    }
    
    
           
            /*
     @GetMapping("/started_sesion/User_Main_Page")
    public String Main_Page(Model model, User user){
      var communities = communityService.getCommunities();
        
        model.addAttribute("communities",communities);
        return "/started_sesion/User_Main_Page";
    }
*/
}