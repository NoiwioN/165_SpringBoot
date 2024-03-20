package net.gibb.kletterapp.services.relations;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.HAS_CLIMBED;
import net.gibb.kletterapp.repositories.relations.HAS_CLIMBEDRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Has_ClimbedService {
    private final HAS_CLIMBEDRepository hasClimbedRepository;


    public Has_ClimbedService(HAS_CLIMBEDRepository hasClimbedRepository) {
        this.hasClimbedRepository = hasClimbedRepository;
    }

    public List<Climber> findAllByRouteId(Long id) {

        return hasClimbedRepository.getAllByRouteId(id);
    }

    public HAS_CLIMBED findById(Long id) {
        Optional<HAS_CLIMBED> r = hasClimbedRepository.findById(id);
        return r.orElseThrow();
    }

    public List<HAS_CLIMBED> findAll() {
        return hasClimbedRepository.findAll();
    }

    public void deleteById(Long id) {
        hasClimbedRepository.deleteById(id);
    }

    public void update(Long id, HAS_CLIMBED hasClimbed) {
        hasClimbedRepository.findById(id).orElseThrow();
        hasClimbedRepository.update(id, hasClimbed.getReview(), hasClimbed.getSuggestedGrade(), hasClimbed.getRating());
    }

    public void create(HAS_CLIMBED hasClimbed) {
        hasClimbedRepository.create(hasClimbed.getClimberId(), hasClimbed.getRouteId(), hasClimbed.getReview(), hasClimbed.isFirstAscend(), hasClimbed.getRating(), hasClimbed.getSuggestedGrade());
    }


}
