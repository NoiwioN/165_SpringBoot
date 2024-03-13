package net.gibb.kletterapp.services;

import io.netty.handler.codec.EncoderException;
import net.gibb.kletterapp.models.Moderator;
import net.gibb.kletterapp.repositories.ModeratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeratorService {
 private final ModeratorRepository moderatorRepository;

    public ModeratorService(ModeratorRepository moderatorRepository) {
        this.moderatorRepository = moderatorRepository;
    }
    public List<Moderator> findAll() {
        return moderatorRepository.findAll();
    }
    public Moderator findById(Long id) {
        return moderatorRepository.findById(id).orElseThrow(EncoderException::new);
    }
    public void update(Moderator moderator) {
        Iterable<Moderator> moderatoren = findAll();
        for (Moderator m : moderatoren) {
            if (m.getId().equals(moderator.getId())) {
                moderatorRepository.save(moderator);
                return;
            }
        }
        throw new RuntimeException("User doesn't exist");
    }

    public void create(Moderator moderator){
        moderatorRepository.save(moderator);
    }
    public void deleteById(Long id){
        moderatorRepository.deleteById(id);
    }


}
