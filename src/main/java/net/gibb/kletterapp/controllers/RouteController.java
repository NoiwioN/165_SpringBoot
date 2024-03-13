package net.gibb.kletterapp.controllers;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.Route;
import net.gibb.kletterapp.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/routen")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @GetMapping
    public ResponseEntity<List<Route>> findAll(){
        return new ResponseEntity<>(routeService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public Route findById(@PathVariable Long id){
        try{return routeService.findById(id);}catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer wurde nicht gefunden");
        }

    }


    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @RequestBody Route route) {
        try {
            routeService.update(route);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht aktualisiert werden");
        }
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Route route){
        try {
            routeService.create(route);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht erstellt werden");
        }
    }
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id){
        try {
            routeService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer konnte nicht gelöscht werden");
        }

    }

}
