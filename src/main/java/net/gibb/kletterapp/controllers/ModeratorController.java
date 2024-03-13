package net.gibb.kletterapp.controllers;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.Moderator;
import net.gibb.kletterapp.services.ModeratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="moderatoren")
public class ModeratorController {
    private final ModeratorService moderatorService;

    public ModeratorController(ModeratorService moderatorService) {
        this.moderatorService = moderatorService;
    }
    @GetMapping
    public ResponseEntity<List<Moderator>> findAll(){
        return new ResponseEntity<>(moderatorService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public Moderator findById(@PathVariable Long id){
        try{return moderatorService.findById(id);}catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer wurde nicht gefunden");
        }

    }


    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @RequestBody Moderator moderator) {
        try {
            moderatorService.update(moderator);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht aktualisiert werden");
        }
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Moderator moderator){
        try {
            moderatorService.create(moderator);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht erstellt werden");
        }
    }
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id){
        try {
            moderatorService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht gelöscht werden");
        }

    }

}
