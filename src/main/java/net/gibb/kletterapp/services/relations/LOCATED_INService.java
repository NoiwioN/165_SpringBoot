package net.gibb.kletterapp.services.relations;

import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import net.gibb.kletterapp.models.relationships.LOCATED_IN;
import net.gibb.kletterapp.repositories.relations.LOCATED_INRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LOCATED_INService {
    private final LOCATED_INRepository locatedInRepository;

    public LOCATED_INService(LOCATED_INRepository locatedInRepository) {
        this.locatedInRepository = locatedInRepository;
    }

    public LOCATED_IN findById(Long id){
        return locatedInRepository.findById(id).orElseThrow();
    }

    public List<LOCATED_IN> findAll(){
        return locatedInRepository.findAll();
    }

    public void delete (Long id){
        locatedInRepository.delete(id);
    }

    public void update (Long id, LOCATED_IN locatedIn){
        locatedIn.setId(id);
        locatedInRepository.update(locatedIn.getId(), locatedIn.getDistance());
    }

    public void create (LOCATED_IN locatedIn){
        locatedInRepository.create(locatedIn.getRouteId(), locatedIn.getOrtId());
    }
}
