package net.gibb.kletterapp.repositories.relations;

import net.gibb.kletterapp.models.relationships.ADMINISTERS;
import net.gibb.kletterapp.models.relationships.LOCATED_IN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ADMINISTERSRepository extends Neo4jRepository<ADMINISTERS,Long> {
    @Query("MATCH(o:Ort)<-[b:ADMINISTERS]-(m:Moderator) return id(o) as ortId, id(b) as id, id(m) as moderatorId, b.modMail as modMail")
    List<ADMINISTERS> findAll();

    @Query("MATCH(o:Ort)<-[b:ADMINISTERS]-(m:Moderator) WHERE id(b)=$id return id(o) as ortId, id(b) as id, id(m) as moderatorId, b.modMail as modMail")
    @Override
    Optional<ADMINISTERS> findById(Long id);

    @Query("MATCH(o:Ort)<-[b:ADMINISTERS]-(m:Moderator) WHERE id(b)=$id DELETE b")
    void delete(Long id);

    @Query("MATCH(o:Ort)<-[b:ADMINISTERS]-(m:Moderator) WHERE id(b)=$id SET b.modMail=$modMail")
    void update(Long id, String modMail);
    @Query("MATCH(o:Ort) MATCH (m:Moderator) WHERE id(o)=$ortId AND id(m) = $moderatorId MERGE(o)<-[b:ADMINISTERS]-(m) SET b.modMail=$modMail")
    void create(Long ortId, Long moderatorId, String modMail);
}
