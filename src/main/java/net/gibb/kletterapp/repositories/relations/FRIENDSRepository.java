package net.gibb.kletterapp.repositories.relations;

import net.gibb.kletterapp.models.relationships.ADMINISTERS;
import net.gibb.kletterapp.models.relationships.FRIENDS;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FRIENDSRepository extends Neo4jRepository<FRIENDS,Long> {
    @Query("MATCH(c1:Climber)<-[b:FRIENDS]->(c2:Climber) RETURN id(c1) as climberOneId, id(c2) as climberTwoId, id(b)as id,b.since as since")
    List<FRIENDS> findAll();

    @Query("MATCH(c1:Climber)<-[b:FRIENDS]->(c2:Climber) WHERE id(b)=$id RETURN b, id(b) as id, id(c1) as climberOneId, id(c2) as climberTwoId,b.since as since LIMIT 1")
    Optional<FRIENDS> findById(Long id);

    @Query("MATCH(c1:Climber)<-[b:FRIENDS]->(c2:Climber) WHERE id(b)=$id delete b")
    void delete(Long id);

    @Query("MATCH(c1:Climber)<-[b:FRIENDS]->(c2:Climber) WHERE id(b)=$id SET b.since=$since")
    void update(Long id, String since);
    @Query("MATCH (c1:Climber) MATCH (c2:Climber) WHERE id(c1)=$climberOneId AND id(c2)=$climberTwoId " +
            "MERGE (c1)<-[b1:FRIENDS]->(c2)" +
            "SET b1.since=$since")
    void create(Long climberOneId, Long climberTwoId, String since);
}
