package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.Route;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends Neo4jRepository<Route, Long> {
}
