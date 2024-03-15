package net.gibb.kletterapp.repositories;

import net.gibb.kletterapp.models.HAS_CLIMBED;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HAS_CLIMBEDRepository extends Neo4jRepository<HAS_CLIMBED,Long> {

/*    @Query("MATCH(c:Climber)-[b:HAS_CLIMBED]->(r:Route)" +
            "WHERE id(c)=$id " +
            "RETURN b.isFirstAscend as isFirstAscend, b.review as review, b.rating as rating, b.suggestedGrade as suggestedGrade, id(b) as id")*/
@Query("MATCH (c:Climber)-[b:HAS_CLIMBED]->(r:Route)" +
        "WHERE id(c)=$id " +
        "RETURN collect({ isFirstAscend: b.isFirstAscend, review: b.review, rating: b.rating, suggestedGrade: b.suggestedGrade, id: id(b) }) as climbs")

    List<HAS_CLIMBED> findHAS_CLIMBEDByUserId(Long id);
}
