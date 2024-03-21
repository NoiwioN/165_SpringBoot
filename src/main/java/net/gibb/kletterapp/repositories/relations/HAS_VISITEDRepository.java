package net.gibb.kletterapp.repositories.relations;

import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HAS_VISITEDRepository extends Neo4jRepository<HAS_VISITED, Long> {
    @Query("MATCH(c:Climber)-[b:HAS_VISITED]->(o:Ort) return b.times as times, id(c) as climberId, id(o) as ortId, id(b) as id")
    List<HAS_VISITED> findAll();

    @Query("MATCH(c:Climber)-[b:HAS_VISITED]->(o:Ort) WHERE id(b)=$id return b.times as times, id(c) as climberId, id(o) as ortId, id(b) as id")
    @Override
    Optional<HAS_VISITED> findById(Long id);

    @Query("MATCH(c:Climber)-[b:HAS_VISITED]->(o:Ort) WHERE id(b)=$id DELETE b")
    void delete(Long id);

    @Query("MATCH(c:Climber)-[b:HAS_VISITED]->(o:Ort) WHERE id(b)=$id SET b.times=$times")
    void update(Long id, Integer times);
    @Query("MATCH (c:Climber) MATCH (o:Ort) WHERE id(c)=$userId AND id(o)=$ortId MERGE (c)-[b:HAS_VISITED]->(o) SET b.times=$times")
    void create(Long id, Long userId, Long ortId, Integer times);
}
