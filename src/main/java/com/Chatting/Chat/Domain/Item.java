
package com.Chatting.Chat.Domain;

import lombok.Data;

@Data
public class Item extends Community{
    
    private int cantidad;

    public Item() {
       
    }

    public Item(Community community) {
        super.setId_community(community.getId_community());
        super.setDescrip(community.getDescrip());
        super.setCommunity_name(community.getCommunity_name());
        super.setImg(community.getImg());
        super.setUsers(community.getUsers());
        this.cantidad=0;
    }
    
    
}
