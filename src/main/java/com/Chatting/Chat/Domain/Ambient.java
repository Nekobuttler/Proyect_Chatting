
package com.Chatting.Chat.Domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="ambient")
public class Ambient implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ambient")
     private Long id_ambient;
     private Long id_category;  
     private Long id_community;

    public Ambient(){}

    public Ambient(Long id_category, Long id_community) {
        this.id_category = id_category;
        this.id_community = id_community;
    }

   
   
    
    
}
