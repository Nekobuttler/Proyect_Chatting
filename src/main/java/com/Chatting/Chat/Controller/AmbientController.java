
package com.Chatting.Chat.Controller;

import com.Chatting.Chat.Dao.AmbientRepository;
import com.Chatting.Chat.Domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Chatting.Chat.Service.CategoryService;
import org.springframework.stereotype.Controller;

@Controller
public class AmbientController {
    
    @Autowired
    private AmbientRepository Ambirepo;
    
    @Autowired
    private CategoryService categoriesService;
    
  // @GetMapping("/Searchable")
  //  public String CommunitiesSearch(Category category ,Model model){
  //      var list =Ambirepo.findAllById(category.getId_category());
        

     
    
    

}
