/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Controller;

import com.Chatting.Chat.Domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Chatting.Chat.Service.CategoryService;

/**
 *
 * @author okk
 */
public class CategoryController {
     @Autowired
    private CategoryService categoriesService;
    
     
     @GetMapping("/SeeData")
    public String dataVisualization(Model model) {
        var categories = categoriesService.getCategories();
        model.addAttribute("categories", categories);
        return "index";
       
    }
    
    @PostMapping("/saveCategory")
    public String guardarCategory(Category category){
       categoriesService.save(category);
        return "redirect:/";
                
   }
    
   @GetMapping("/CreateCategory")
    public String CreateCategory(Category category){
        return "categoryCreation";
    }
    
    
    
     // @GetMapping("/")
    //public String modificarArticulo(Model model){
        
    //    var articulos= artService.getArticulos();
   //     model.addAttribute("articulos", articulos);
        
  //      return "index";
                
  //  }
    
    @GetMapping("/eliminarCategory/{id_categories}")
    public String deleteCategory(Category category){
       categoriesService.delete(category);
        
        return "redirect:/";
          }
    
    

}
