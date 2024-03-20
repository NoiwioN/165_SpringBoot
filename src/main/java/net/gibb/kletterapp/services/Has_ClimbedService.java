package net.gibb.kletterapp.services;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.HAS_CLIMBED;
import net.gibb.kletterapp.repositories.HAS_CLIMBEDRepository;
import org.apache.commons.lang3.exception.ExceptionContext;
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
        return r.orElseThrow(ExceptionInInitializerError::new);
    }

}
