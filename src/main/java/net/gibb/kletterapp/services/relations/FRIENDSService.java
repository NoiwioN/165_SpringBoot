package net.gibb.kletterapp.services.relations;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.relationships.ADMINISTERS;
import net.gibb.kletterapp.models.relationships.FRIENDS;
import net.gibb.kletterapp.models.relationships.HAS_CLIMBED;
import net.gibb.kletterapp.repositories.relations.FRIENDSRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FRIENDSService {
    private final FRIENDSRepository friendsRepository;

    public FRIENDSService(FRIENDSRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }
    public FRIENDS findById(Long id){
        return friendsRepository.findById(id).orElseThrow();
    }

    public List<FRIENDS> findAll(){
        return friendsRepository.findAll();
    }

    public void delete (Long id){
        friendsRepository.delete(id);
    }

    public void update (Long id, FRIENDS friends){
        friends.setId(id);
        friendsRepository.update(friends.getId(), friends.getSince());
    }

    public void create (FRIENDS friends){
        friendsRepository.create(friends.getClimberOneId(), friends.getClimberTwoId(), friends.getSince());
        friendsRepository.create(friends.getClimberTwoId(),friends.getClimberOneId(), friends.getSince());
    }


}
