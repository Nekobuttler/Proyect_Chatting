
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

public class IndexController {
    
    @Autowired
    
    
    
    @GetMapping("/")
    public String start(){
        
        return "Main_Page";
    }
    
    
}