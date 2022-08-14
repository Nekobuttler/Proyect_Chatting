
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
@Table(name="members")
public class Members implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id_members;
    
    private Long id_user;
    private Long id_community;

    public Members(){}
    
    public Members(Long id_community, Long id_user) {
       
        this.id_community=id_community;
        this.id_user=id_user;
    }
    
    
    
}
