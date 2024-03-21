package net.gibb.kletterapp.services.relations;

import net.gibb.kletterapp.models.relationships.ADMINISTERS;
import net.gibb.kletterapp.models.relationships.LOCATED_IN;
import net.gibb.kletterapp.repositories.relations.ADMINISTERSRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ADMINISTERSService {
    private final ADMINISTERSRepository administersRepository;

    public ADMINISTERSService(ADMINISTERSRepository administersRepository) {
        this.administersRepository = administersRepository;
    }
    public ADMINISTERS findById(Long id){
        return administersRepository.findById(id).orElseThrow();
    }

    public List<ADMINISTERS> findAll(){
        return administersRepository.findAll();
    }

    public void delete (Long id){
        administersRepository.delete(id);
    }

    public void update (Long id, ADMINISTERS administers){
        administers.setId(id);
        administersRepository.update(administers.getId(), administers.getModMail());
    }

    public void create (ADMINISTERS administers){
        administersRepository.create(administers.getOrtId(), administers.getModeratorId(), administers.getModMail());
    }
}
