
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
@Entity(name="members")
@Table(name="members")
public class Members implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_members")
     private Long id_members;
    
    @JoinColumn(name="id_user",referencedColumnName = "id_user")
    private User user;
    
    @JoinColumn(name="id_ccommunity",referencedColumnName = "id_ccommunity")
    private Community community;

    public Members(){}
    
    public Members(Community community, User user) {
       
        this.community=community;
        this.user=user;
    }
    
    
    
}
