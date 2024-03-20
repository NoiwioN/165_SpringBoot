package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.HAS_CLIMBED;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HAS_CLIMBEDRepository extends Neo4jRepository<HAS_CLIMBED,Long> {
    @Query("MATCH (c:Climber)-[:HAS_CLIMBED]->(r:Route) WHERE id(r)=$id return c.proficiency as proficiency, c.age as age, $id as id, c.wingspan as wingspan, c.username as username, c.name as name, c.birthday as birthday, c.height as height")
public List<Climber> getAllByRouteId (Long id);
    @Query("MATCH (c:Climber)-[b:HAS_CLIMBED]->(r:Route) \n" +
            "WHERE id(b) = $id \n" +
            "RETURN b.review as review, b.isFirstAscend as isFirstAscend, \n" +
            "b.suggestedGrade as suggestedGrade, b.rating as rating\n, id(c) as climberId, id(r) as routeId, id(b) as id")
    Optional<HAS_CLIMBED> findById(Long id);
}
