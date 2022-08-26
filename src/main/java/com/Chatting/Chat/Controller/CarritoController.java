
package com.Chatting.Chat.Controller;



import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.Item;
import com.Chatting.Chat.Domain.User;
import com.Chatting.Chat.Service.AmbientService;
import com.Chatting.Chat.Service.CategoryService;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.CommunityService;
import com.Chatting.Chat.Service.ItemService;
import com.Chatting.Chat.Service.MembersService;
import com.Chatting.Chat.Service.UserService;
import java.lang.reflect.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@Slf4j
public class CarritoController {
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private CommunityService communityService;
    
    
    @GetMapping("/carrito/listado")
    public String start(Model model){
        var items =itemService.getItems();
        model.addAttribute("items",items);
        var carritoTotal=0;
        for(Item i : items){
            carritoTotal+=(i.getCantidad() * i.getUsers());
        }
        model.addAttribute("carritoTotal", carritoTotal);
        return "/carrito/listado";
    }
    
    @GetMapping("carrito/agregar/{id_community}")
    public ModelAndView agregarArticulo(Model model , Item item){
        Item item2 = itemService.getItem(item);
        if(item2==null){
        Community community = communityService.getCommunity(item2);
        item2 = new Item(community);
        }
        itemService.save(item2);
        var list= itemService.getItems();
        var totalCarro=0;
        var carritoTotal=0;
        for(Item i : list){
            totalCarro=i.getCantidad();
            carritoTotal += (i.getCantidad()* i.getUsers());
        }
        
        model.addAttribute("list",list);
        model.addAttribute("total",totalCarro);
        model.addAttribute("carroTotal",carritoTotal);
        return new ModelAndView("/cart/CartFragment :: verCarrito");
    }
    
    @GetMapping("/carrito/modificar/{id_community}")
    public String modificarCarrito(Item item, Model model){
        item= itemService.getItem(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }
    
    @GetMapping("/carrito/eliminar/{id_community}")
    public String eliminarItem(Item item){
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }
    
    @PostMapping("/carrito/guardar")
    public String Guardar(Item item){
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
    
    
    @GetMapping("/facturar/carrito")
    public String facturarCarrito(){
        itemService.facturar();
        return "redirec:/";
    }
    
}