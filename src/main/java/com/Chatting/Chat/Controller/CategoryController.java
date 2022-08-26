
package com.Chatting.Chat.Controller;

import com.Chatting.Chat.Domain.Category;
import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.AmbientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Chatting.Chat.Service.CategoryService;
import com.Chatting.Chat.Service.CommunityService;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    
    @Autowired
    private CategoryService categoriesService;
    @Autowired
    private CommunityService communityService;
    
    @Autowired
    private AmbientService ambientService;
    
     @GetMapping("/category/new")
    public String newCategory(Category category, User user){
        return "category/Confi";
    }
   
  /*  @PostMapping("/category/search")
    public String search(Category category, Model model){
        category = categoriesService.g
    }
    */
     
     @GetMapping("category/list")
    public String CategoryData(Model model,User user) {
        var categories = categoriesService.getCategories();
        model.addAttribute("categories", categories);
        //model.addAttribute("user",user);
        return "category/list";
       
    }
    
    @PostMapping("/category/save")
    public String guardarCategory(Category category){
       categoriesService.save(category);
        return "redirect:/category/list";
                
   }
  
    
    
      @GetMapping("/category/Confi/{id_category}")
    public String ConfiCategory(Model model, Category category,User user){
        
        category= categoriesService.getCategory(category);
        model.addAttribute("category", category);
        
        return "category/Confi";

   }
    
    @GetMapping("/category/erase/{id_category}")
    public String deleteCategory(Category category, User user){
       categoriesService.delete(category);
        
        return "redirect:/category/list";
          }
    
    
    
    @GetMapping("category/search/{id_category}")
    public String searchByCategory(Model model,User user,Category category) {
        category=categoriesService.getCategory(category);
        var categories = categoriesService.getCategory(category);
        var communities = communityService.getCommunities();
        var ambients= ambientService.getAmbients();
        model.addAttribute("categories", categories);
         model.addAttribute("communities", communities);
         model.addAttribute("ambients", ambients);
        //model.addAttribute("user",user);
        return "category/result";
       
    }

}
