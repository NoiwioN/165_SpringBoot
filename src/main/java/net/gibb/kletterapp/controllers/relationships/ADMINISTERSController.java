package net.gibb.kletterapp.controllers.relationships;

import net.gibb.kletterapp.models.relationships.ADMINISTERS;
import net.gibb.kletterapp.models.relationships.HAS_VISITED;
import net.gibb.kletterapp.repositories.relations.ADMINISTERSRepository;
import net.gibb.kletterapp.services.relations.ADMINISTERSService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/administers")
public class ADMINISTERSController {
    private final ADMINISTERSService administersService;

    public ADMINISTERSController(ADMINISTERSService administersService) {
        this.administersService = administersService;
    }
    @GetMapping
    public List<ADMINISTERS> findAll() {
        return administersService.findAll();
    }

    @GetMapping(path = "{id}")
    public ADMINISTERS findById(@PathVariable Long id) {
        try {
            return administersService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            administersService.delete(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes = "application/json", path = "{id}")
    public void update(@PathVariable Long id, @RequestBody ADMINISTERS administers) {
        try {
            administersService.update(id, administers);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(consumes = "application/json")
    public void create(@RequestBody ADMINISTERS administers) {

        administersService.create(administers);

    }
}
