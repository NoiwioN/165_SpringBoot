package net.gibb.kletterapp.repositories.relations;

import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import net.gibb.kletterapp.models.relationships.LOCATED_IN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LOCATED_INRepository extends Neo4jRepository<LOCATED_IN,Long> {
    @Query("MATCH(r:Route)-[b:LOCATED_IN]->(o:Ort) return id(b) as id, id(r) as routeId, id(o) as ortId, b.distance as distance")
    List<LOCATED_IN> findAll();

    @Query("MATCH(r:Route)-[b:LOCATED_IN]->(o:Ort) WHERE id(b)=$id return id(b) as id, id(r) as routeId, id(o) as ortId, b.distance as distance")
    @Override
    Optional<LOCATED_IN> findById(Long id);

    @Query("MATCH(r:Route)-[b:LOCATED_IN]->(o:Ort) WHERE id(b)=$id DELETE b")
    void delete(Long id);

    @Query("MATCH(r:Route)-[b:LOCATED_IN]->(o:Ort) WHERE id(b)=$id SET b.distance=$distance")
    void update(Long id, Integer distance);
    @Query("MATCH(r:Route) MATCH (o:Ort) WHERE id(r)=$routeId AND id(o)= $ortId MERGE (r)-[b:LOCATED_IN]->(o) SET b.distance = toInteger(point.distance(o.address, r.coordinates))")
    void create(Long routeId, Long ortId);
}
