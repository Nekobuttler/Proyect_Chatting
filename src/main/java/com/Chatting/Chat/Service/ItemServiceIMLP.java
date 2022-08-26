/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Chatting.Chat.Service;


import com.Chatting.Chat.Domain.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ItemServiceIMLP implements ItemService {
    
    
    
    

    @Override
    public List<Item> getItems() {
        return listItems;
    }

    @Override
    public void save(Item item) {
        boolean exist = false;
        for(Item c: listItems){
            if(Objects.equals(c.getId_community(), item.getId_community())){
                if(c.getCantidad()<item.getCantidad()){
                    c.setCantidad(c.getCantidad()+1);
                }
                exist =true ;
                break;
            }
        }
        if(!exist){
            item.setCantidad(1);
            listItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var exist =false;
        for(Item c : listItems){
            ++posicion;
            if(Objects.equals(c.getId_community(), item.getId_community())){
                exist=true;
                break;
            }
        }
        if(exist){
            listItems.remove(posicion);
        }
    }

    @Override
    public Item getItem(Item item) {
        for(Item c : listItems){
            if(Objects.equals(c.getId_community(), item.getId_community())){
                return c;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
         
        for(Item i : listItems){
            if(Objects.equals(i.getId_community(), item.getId_community())){
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturar() {
        for(Item i: listItems){
        
        }
        listItems.clear();
    }
    
}