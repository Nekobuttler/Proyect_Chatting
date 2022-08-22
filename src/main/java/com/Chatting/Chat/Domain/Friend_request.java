
package com.Chatting.Chat.Domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="friend_request")
public class Friend_request implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_fr")
     private Long id_fr;
    
    @JoinColumn(name="id_user",referencedColumnName = "id_user")
    private User Suser;
    @JoinColumn(name="id_user",referencedColumnName = "id_user")
    private User Ruser;

    public Friend_request(){}

    public Friend_request(User Suser, User Ruser) {
        this.Suser = Suser;
        this.Ruser = Ruser;
    }
    
   
    
    
    
}
