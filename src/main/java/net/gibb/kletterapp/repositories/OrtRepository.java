package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.Ort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrtRepository extends Neo4jRepository<Ort,Long> {
}
