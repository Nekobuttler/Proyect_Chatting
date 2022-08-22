
package com.Chatting.Chat.Dao;
import com.Chatting.Chat.Domain.Community;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CommunityDao extends CrudRepository<Community, Long>{
    
    @Query(value="SELECT c FROM community c WHERE c.community_name=?1")
    public List<Community> findByCommunity_name(final String community_name);
    
   
    
}
