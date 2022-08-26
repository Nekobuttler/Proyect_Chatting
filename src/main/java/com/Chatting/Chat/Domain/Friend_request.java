
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
    
    @JoinColumn(name="id_suser",referencedColumnName = "id_user")
    private Long Suser;
    @JoinColumn(name="id_ruser",referencedColumnName = "id_user")
    private Long Ruser;
    @Column(name="state")
    private boolean state;
    public Friend_request(){}

    public Friend_request(Long Suser, Long Ruser,boolean state) {
        this.Suser = Suser;
        this.Ruser = Ruser;
        this.state = state;
    }

    
    
}
