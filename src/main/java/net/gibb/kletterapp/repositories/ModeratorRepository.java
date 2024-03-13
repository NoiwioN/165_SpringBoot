package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.Moderator;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends Neo4jRepository<Moderator, Long> {
}
