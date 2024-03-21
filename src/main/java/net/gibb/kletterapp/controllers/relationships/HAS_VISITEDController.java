package net.gibb.kletterapp.controllers.relationships;

import net.gibb.kletterapp.models.relationships.HAS_CLIMBED;
import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import net.gibb.kletterapp.services.relations.HAS_VISITEDService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/has_visited")
public class HAS_VISITEDController {
    private final HAS_VISITEDService hasVisitedService;

    public HAS_VISITEDController(HAS_VISITEDService hasVisitedService) {
        this.hasVisitedService = hasVisitedService;
    }

    @GetMapping
    public List<HAS_VISITED> findById() {
        return hasVisitedService.findAll();
    }

    @GetMapping(path = "{id}")
    public HAS_VISITED findById(@PathVariable Long id) {
        try {
            return hasVisitedService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            hasVisitedService.delete(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes = "application/json", path = "{id}")
    public void update(@PathVariable Long id, @RequestBody HAS_VISITED hasVisited) {
        try {
            hasVisitedService.update(id, hasVisited);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(consumes = "application/json")
    public void create(@RequestBody HAS_VISITED hasVisited) {

        hasVisitedService.create(hasVisited);

    }
}
