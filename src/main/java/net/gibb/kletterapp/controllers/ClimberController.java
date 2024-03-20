package net.gibb.kletterapp.controllers;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.services.ClimberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/climbers")
public class ClimberController {
    private final ClimberService climberService;

    public ClimberController(ClimberService climberService) {
        this.climberService = climberService;
    }

    @GetMapping
    public ResponseEntity<List<Climber>> findAll(){
        return new ResponseEntity<>(climberService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public Climber findById(@PathVariable Long id){
        try{return climberService.findById(id);}catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer wurde nicht gefunden");
        }

    }


    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @RequestBody Climber climber) {
        try {
            climberService.update(climber);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht aktualisiert werden");
        }
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Climber climber){
        try {
            climberService.create(climber);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht erstellt werden");
        }
    }
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id){
        try {
            climberService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht gelöscht werden");
        }

    }
 /*   @GetMapping(path = "{id}/has_climbed")
    public List<HAS_CLIMBED> findClimbedRelations(@PathVariable Long id){
        return climberService.findClimbedRelations(id);
    }
    @DeleteMapping(path = "{id}/has_climbed/{id_relation}")
    public void deleteHasClimbedById(@PathVariable Long id,@PathVariable Long id_relation){
        climberService.deleteHasClimbedById(id_relation);
    }
*/
}
