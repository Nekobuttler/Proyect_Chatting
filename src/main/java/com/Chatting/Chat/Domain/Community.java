
package com.Chatting.Chat.Domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity(name="community")
@Table(name="community")
public class Community implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_community")
     private Long id_community;
    
    @Column(name="community_name")
    private String community_name;
    
   @Column(name="users")
    private int users;
   
   @Column(name="descrip")
    private String descrip;
   
    @Column(name="img")
    private String img;

   // @JoinColumn(name="id_ambient",referencedColumnName = "id_ambient")
    //@ManyToOne
   // private Ambient ambient;
    
    public Community(){
    }

    public Community(String community_name, int users, String descrip) {
        this.community_name = community_name;
        this.users = users;
        this.descrip = descrip;
      
    }
    
    
    
    
}
