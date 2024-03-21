package net.gibb.kletterapp.controllers.relationships;

import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import net.gibb.kletterapp.models.relationships.LOCATED_IN;
import net.gibb.kletterapp.services.relations.LOCATED_INService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/located_in")
public class LOCATED_INController {
    private final LOCATED_INService locatedInService;

    public LOCATED_INController(LOCATED_INService locatedInService) {
        this.locatedInService = locatedInService;
    }

    @GetMapping
    public List<LOCATED_IN> findById() {
        return locatedInService.findAll();
    }

    @GetMapping(path = "{id}")
    public LOCATED_IN findById(@PathVariable Long id) {
        try {
            return locatedInService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            locatedInService.delete(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes = "application/json", path = "{id}")
    public void update(@PathVariable Long id, @RequestBody LOCATED_IN locatedIn) {
        try {
            locatedInService.update(id, locatedIn);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(consumes = "application/json")
    public void create(@RequestBody LOCATED_IN locatedIn) {

        locatedInService.create(locatedIn);

    }
}
