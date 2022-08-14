
package com.Chatting.Chat.Controller;

import com.Chatting.Chat.Domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Chatting.Chat.Service.CategoryService;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    
    @Autowired
    private CategoryService categoriesService;
    
     @GetMapping("/category/new")
    public String newCategory(Category category){
        return "category/Confi";
    }
   
  /*  @PostMapping("/category/search")
    public String search(Category category, Model model){
        category = categoriesService.g
    }
    */
     
     @GetMapping("category/list")
    public String CategoryData(Model model) {
        var categories = categoriesService.getCategories();
        model.addAttribute("categories", categories);
        return "category/list";
       
    }
    
    @PostMapping("/category/save")
    public String guardarCategory(Category category){
       categoriesService.save(category);
        return "redirect:/category/list";
                
   }
  
    
      @GetMapping("/category/Confi/{id_category}")
    public String ConfiCategory(Model model, Category category){
        
        category= categoriesService.getCategory(category);
        model.addAttribute("category", category);
        
        return "category/Confi";

   }
    
    @GetMapping("/category/erase/{id_category}")
    public String deleteCategory(Category category){
       categoriesService.delete(category);
        
        return "redirect:/category/list";
          }
    
    

}
