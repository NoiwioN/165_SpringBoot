package net.gibb.kletterapp.services;

import net.gibb.kletterapp.models.HAS_CLIMBED;
import net.gibb.kletterapp.repositories.HAS_CLIMBEDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Has_ClimbedService {
    private final HAS_CLIMBEDRepository hasClimbedRepository;

    public Has_ClimbedService(HAS_CLIMBEDRepository hasClimbedRepository) {
        this.hasClimbedRepository = hasClimbedRepository;
    }
    public List<HAS_CLIMBED> findAll(){
        return hasClimbedRepository.findAll();
    }
}
