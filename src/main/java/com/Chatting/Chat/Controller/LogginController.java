
package com.Chatting.Chat.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogginController {
    
    Logger logger =LoggerFactory.getLogger(LogginController.class);
    
    @RequestMapping("/loggin")
    public String Loggin() {
       logger.trace("Level log: Trace");
       logger.info("Level log: Info");
       logger.debug("Level log: Debug");
       logger.error("Level log: Error");
       logger.warn("Level log: Warn");
        return "wait";
    }
    
    
}
