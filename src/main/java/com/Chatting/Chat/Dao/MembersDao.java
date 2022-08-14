
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.Community;
import com.Chatting.Chat.Domain.Members;
import com.Chatting.Chat.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MembersDao extends CrudRepository<Members, Long>{
    
     @Query(
            value= "SELECT users.username FROM community,members,users WHERE community.id_community = ?1.id_community AND community.id_community = members.id_community AND "
            + "members.id_user = users.id_user " ,
            nativeQuery = true
    )
    public List<User> getUsers(Community community);//se obtiene la id de la comunidad, se a;aden a una lista todos los usuario encontrados en miembros con ese id de comunidad 
    

    @Query(
            value= "SELECT community.* FROM community,members,users WHERE users.username = ?1 AND users.id_user = members.id_user AND "
            + "members.id_community=community.id_community" ,
            nativeQuery = true
    )
    public List<Community> getCommunities(String user);//se obtiene la id del usuario actual, se a;aden a una lista todos las comunidades
                                                     //encontrados en miembros con ese id del usuario y obtner aquellos a las que se ha unido 
     
}
