package net.gibb.kletterapp.controllers.relationships;

import net.gibb.kletterapp.models.relationships.FRIEND_REQUEST_SENT;
import net.gibb.kletterapp.services.relations.FRIEND_REQUEST_SENTService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/friend_request_sent")
public class FRIEND_REQUEST_SENTController {
    private final FRIEND_REQUEST_SENTService friendRequestSentService;

    public FRIEND_REQUEST_SENTController(FRIEND_REQUEST_SENTService friendrequestSentService) {
        this.friendRequestSentService = friendrequestSentService;
    }

    @GetMapping
    public List<FRIEND_REQUEST_SENT> findAll() {
        return friendRequestSentService.findAll();
    }

    @GetMapping(path = "{id}")
    public FRIEND_REQUEST_SENT findById(@PathVariable Long id) {
        try {
            return friendRequestSentService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            friendRequestSentService.delete(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes = "application/json", path = "{id}")
    public void update(@PathVariable Long id, @RequestBody FRIEND_REQUEST_SENT friendrequestSent) {
        try {
            friendRequestSentService.update(id, friendrequestSent);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(consumes = "application/json")
    public void create(@RequestBody FRIEND_REQUEST_SENT friendrequestSent) {

        friendRequestSentService.create(friendrequestSent);

    }
}
