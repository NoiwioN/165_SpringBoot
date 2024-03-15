package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.Climber;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;


import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClimberRepository extends Neo4jRepository<Climber, Long> {

}
