package net.gibb.kletterapp.repositories.relations;

import net.gibb.kletterapp.models.relationships.FRIEND_REQUEST_SENT;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface FRIEND_REQUEST_SENTRepository extends Neo4jRepository<FRIEND_REQUEST_SENT, Long> {

    @Query("MATCH(c1:Climber)<-[b:FRIENDREQUEST_SENT]-(c2:Climber) return id(b) as id, id(c1) as receiverId, id(c2) as senderId, b.requestDate as requestDate ")
    List<FRIEND_REQUEST_SENT> findAll();

    @Query("MATCH(c1:Climber)<-[b:FRIENDREQUEST_SENT]-(c2:Climber) WHERE id(b)=$id return id(b) as id, id(c1) as receiverId, id(c2) as senderId, b.requestDate as requestDate")
    @Override
    Optional<FRIEND_REQUEST_SENT> findById(Long id);

    @Query("MATCH(c1:Climber)<-[b:FRIENDREQUEST_SENT]-(c2:Climber) WHERE id(b)=$id delete b")
    void delete(Long id);

    @Query("MATCH(c1:Climber)<-[b:FRIENDREQUEST_SENT]-(c2:Climber) WHERE id(b)=$id set b.requestDate=$requestDate")
    void update(Long id, String requestDate);
    @Query("MATCH(c1:Climber) MATCH(c2:Climber) WHERE id(c1)=$senderId AND id(c2)=$receiverId"+
            " MERGE (c1)-[b:FRIENDREQUEST_SENT]->(c2)"+
            " SET b.requestDate=toString(date())")
    void create(Long senderId, Long receiverId);
}
