
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.CustomUserDetails;
import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.AmbientService;
import com.Chatting.Chat.Service.CategoryService;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.MembersService;
import com.Chatting.Chat.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

public class LoggedUserController {
    
    @Autowired 
    private CategoryService categoryService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private UserService userService;
    @Autowired
    private MembersService memberService;
    @Autowired 
    private AmbientService ambientService;
    
    
    //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  
    
    
    @GetMapping("/started_sesion/Profile/")
    public String ProfileUser(Model model, User username){
        
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
        
    }
    /*
    @GetMapping("/started_sesion/User_Main_Page")
    public String MyCommunities(String user, Model model){           //change methodology seacrh by name and not id or use
        user=SecurityContextHolder.getContext().getAuthentication().getName();
        var communities = memberService.getCommunities(user);
        model.addAttribute("communities",communities);
        
        return "/started_sesion/User_Main_Page";
    }
    
     
    

    @GetMapping("/started_sesion/User_Main_Page/{id_user}")
    public String MyCommunities(String user, Model model){           //change methodology seacrh by name and not id or use
       
        if(!user.equals(null)){
        var communities = memberService.getCommunities2(user);
        model.addAttribute("communities",communities);
        }else{
        }
        
        return "/started_sesion/User_Main_Page";
        
    }
    
           
    @GetMapping("/started_sesion/User_Main_Page/{username}")
    public String Main_Page(Model model, String username){
      var communities = memberService.getCommunities2(username);
        var categories= categoryService.getCategories();
        var ambients= ambientService.getAmbients();
        model.addAttribute("communities",communities);
         model.addAttribute("ambients",ambients);
          model.addAttribute("categories",categories);
        return "/started_sesion/User_Main_Page";
    }
*/
            
     @GetMapping("/started_sesion/User_Main_Page")
    public String Main_Page(Model model, User user){
      var communities = communityService.getCommunities();
        var categories= categoryService.getCategories();
        var ambients= ambientService.getAmbients();
        model.addAttribute("communities",communities);
         model.addAttribute("ambients",ambients);
          model.addAttribute("categories",categories);
        return "/started_sesion/User_Main_Page";
    }

}