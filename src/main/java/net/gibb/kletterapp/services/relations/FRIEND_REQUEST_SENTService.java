package net.gibb.kletterapp.services.relations;

import net.gibb.kletterapp.models.relationships.FRIEND_REQUEST_SENT;
import net.gibb.kletterapp.repositories.relations.FRIEND_REQUEST_SENTRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FRIEND_REQUEST_SENTService {
    private final FRIEND_REQUEST_SENTRepository friendrequestSentRepository;

    public FRIEND_REQUEST_SENTService(FRIEND_REQUEST_SENTRepository friendrequestSentRepository) {
        this.friendrequestSentRepository = friendrequestSentRepository;
    }
    public FRIEND_REQUEST_SENT findById(Long id){
        return friendrequestSentRepository.findById(id).orElseThrow();
    }

    public List<FRIEND_REQUEST_SENT> findAll(){
        return friendrequestSentRepository.findAll();
    }

    public void delete (Long id){
        friendrequestSentRepository.delete(id);
    }

    public void update (Long id, FRIEND_REQUEST_SENT friendrequestSent){
        friendrequestSent.setId(id);
        friendrequestSentRepository.update(friendrequestSent.getId(), friendrequestSent.getRequestDate());
    }

    public void create (FRIEND_REQUEST_SENT friendrequestSent){
        friendrequestSentRepository.create(friendrequestSent.getSenderId(), friendrequestSent.getReceiverId());
    }
}
