package net.gibb.kletterapp.controllers.relationships;

import net.gibb.kletterapp.models.relationships.HAS_CLIMBED;
import net.gibb.kletterapp.services.relations.Has_ClimbedService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/has_climbed")
public class Has_ClimbedController {
    private final Has_ClimbedService hasClimbedService;

    public Has_ClimbedController(Has_ClimbedService hasClimbedService) {
        this.hasClimbedService = hasClimbedService;
    }

    @GetMapping
    public List<HAS_CLIMBED> findAllByRouteId(@RequestParam(required = false) Long routeId, @RequestParam(required = false) Long climberId) {
        return hasClimbedService.findAll();
    }

    @GetMapping(path = "{id}")
    public HAS_CLIMBED findAll(@PathVariable Long id) {
        try {
            return hasClimbedService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            hasClimbedService.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(consumes = "application/json", path = "{id}")
    public void update (@PathVariable Long id, @RequestBody HAS_CLIMBED hasClimbed){
        try{
            hasClimbedService.update(id, hasClimbed);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @PostMapping(consumes = "application/json")
    public void create (@RequestBody HAS_CLIMBED hasClimbed){

            hasClimbedService.create(hasClimbed);

    }

}
