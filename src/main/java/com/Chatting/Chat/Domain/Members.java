
package com.Chatting.Chat.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="users")
public class Members implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id_user;
    
    private String username;
    private String email;
    private String password;
    private int edad;

    public Members(){}
    
    public Members(String username, String email, String password, int edad) {
       
        this.username = username;
        this.email = email;
        this.password = password;
        this.edad = edad;
    }
    
    
    
}
