
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
@Entity(name="category")
@Table(name="category")
public class Category implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long id_category;
    
    @Column(name = "category_name")
    private String category_name;

    public Category(){}

    public Category(String category_name) {
        this.category_name = category_name;
    }

  
    
   
    
    
    
}
