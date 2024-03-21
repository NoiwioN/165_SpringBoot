package net.gibb.kletterapp.services.relations;

import net.gibb.kletterapp.models.relationships.HAS_CLIMBED;
import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import net.gibb.kletterapp.repositories.relations.HAS_VISITEDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HAS_VISITEDService {
    private final HAS_VISITEDRepository hasVisitedRepository;

    public HAS_VISITEDService(HAS_VISITEDRepository hasVisitedRepository) {
        this.hasVisitedRepository = hasVisitedRepository;
    }

    public HAS_VISITED findById(Long id){
        return hasVisitedRepository.findById(id).orElseThrow();
    }

    public List<HAS_VISITED> findAll(){
        return hasVisitedRepository.findAll();
    }

    public void delete (Long id){
         hasVisitedRepository.delete(id);
    }

    public void update (Long id, HAS_VISITED hasVisited){
        hasVisited.setId(id);
        hasVisitedRepository.update(hasVisited.getId(), hasVisited.getTimes());
    }

    public void create (HAS_VISITED hasVisited){
        hasVisitedRepository.create(hasVisited.getId(),hasVisited.getClimberId(), hasVisited.getOrtId(), hasVisited.getTimes());
    }
}
