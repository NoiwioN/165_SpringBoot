package net.gibb.kletterapp.services;

import io.netty.handler.codec.EncoderException;
import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.HAS_CLIMBED;
import net.gibb.kletterapp.repositories.ClimberRepository;
import net.gibb.kletterapp.repositories.HAS_CLIMBEDRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClimberService {
    private final ClimberRepository climberRepository;
    private final HAS_CLIMBEDRepository hasClimbedRepository;


    public ClimberService(ClimberRepository climberRepository, HAS_CLIMBEDRepository hasClimbedRepository) {
        this.climberRepository = climberRepository;
        this.hasClimbedRepository = hasClimbedRepository;
    }

    public List<Climber> findAll() {
        return climberRepository.findAll();
    }

    public Climber findById(Long id) {
        return climberRepository.findById(id).orElseThrow(EncoderException::new);
    }
    public void update(Climber climber) {
        Iterable<Climber> climbers = findAll();
        for (Climber c : climbers) {
            if (c.getId().equals(climber.getId())) {
                climberRepository.save(climber);
                return;
            }
        }
        throw new RuntimeException("User doesn't exist");
    }

    public void create(Climber climber){
        climberRepository.save(climber);
    }
    public void deleteById(Long id){
        climberRepository.deleteById(id);
    }

    public List<HAS_CLIMBED> findClimbedRelations(Long id){
        return  hasClimbedRepository.findHAS_CLIMBEDByUserId(id);
    }
    public void deleteHasClimbedById (Long idRelation){
        hasClimbedRepository.deleteById(idRelation);
    }

}
