package net.gibb.kletterapp.controllers.relationships;

import net.gibb.kletterapp.models.relationships.ADMINISTERS;
import net.gibb.kletterapp.models.relationships.FRIENDS;
import net.gibb.kletterapp.services.relations.FRIENDSService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/friends")
public class FRIENDSController {
    private final FRIENDSService friendsService;

    public FRIENDSController(FRIENDSService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping
    public List<FRIENDS> findAll() {
        return friendsService.findAll();
    }

    @GetMapping(path = "{id}")
    public FRIENDS findById(@PathVariable Long id) {
        try {
            return friendsService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            friendsService.delete(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes = "application/json", path = "{id}")
    public void update(@PathVariable Long id, @RequestBody FRIENDS friends) {
        try {
            friendsService.update(id, friends);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(consumes = "application/json")
    public void create(@RequestBody FRIENDS friends) {

        friendsService.create(friends);

    }


}
