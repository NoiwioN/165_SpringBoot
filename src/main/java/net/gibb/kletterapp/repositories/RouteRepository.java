package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.Route;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends Neo4jRepository<Route, Long> {
    @Query("MATCH (c:Climber)-[:HAS_CLIMBED]->(r:Route) WHERE id(r)=$id RETURN id(c) AS id, c.wingspan AS wingspan, c.username AS username, c.name AS name, c.proficiency AS proficiency, c.birthday AS birthday, c.age AS age, c.height AS height, c.requestedFriends AS requestedFriends, c.routes AS routes, c.visitedPlaces AS visitedPlaces")
    List<Climber> findClimbersByRouteId(Long id);
}
