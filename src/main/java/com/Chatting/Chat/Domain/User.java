
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
@Entity(name="users")
@Table(name="users")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long id_user;
    
    @Column(name="username")
    private String username;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="edad")
    private int edad;

    public User(){}
    
    public User(String username, String email, String password, int edad) {
       
        this.username = username;
        this.email = email;
        this.password = password;
        this.edad = edad;
    }
    
    
    
}
