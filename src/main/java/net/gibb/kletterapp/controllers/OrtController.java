package net.gibb.kletterapp.controllers;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.Ort;
import net.gibb.kletterapp.services.OrtService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/orte")
public class OrtController {
    private final OrtService ortService;

    public OrtController(OrtService ortService) {
        this.ortService = ortService;
    }
    @GetMapping
    public List<Ort> findAll(){
        return ortService.findAll();
    }
    @GetMapping(path = "{id}")
    public Ort findById(@PathVariable Long id){
        try{return ortService.findById(id);}catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer wurde nicht gefunden");
        }

    }


    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @RequestBody Ort ort) {
        try {
            ortService.update(ort);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht aktualisiert werden");
        }
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Ort ort){
        try {
            ortService.create(ort);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht erstellt werden");
        }
    }
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id){
        try {
            ortService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht gelöscht werden");
        }

    }
}
