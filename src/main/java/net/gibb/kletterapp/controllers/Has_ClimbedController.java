package net.gibb.kletterapp.controllers;

import net.gibb.kletterapp.models.Climber;
import net.gibb.kletterapp.models.HAS_CLIMBED;
import net.gibb.kletterapp.services.Has_ClimbedService;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/has_climbed")
public class Has_ClimbedController {
 private final Has_ClimbedService hasClimbedService;

    public Has_ClimbedController(Has_ClimbedService hasClimbedService) {
        this.hasClimbedService = hasClimbedService;
    }

/*    @GetMapping
    public List<Climber> findAllByRouteId(@RequestParam(required = false) Long routeId, @RequestParam (required = false) Long climberId){
        if(routeId!=null&&climberId!=null){
            // findByClimberandRouteId
        } else if (climberId!=null) {
            //find by climberId

        } else if (routeId!=null) {
            //find by routeId
            return hasClimbedService.findAllByRouteId(routeId);
        }else{
            //do something
        }

        //nur damit ich jetzt compilen kann.
        ArrayList<Climber> climbers = new ArrayList<>();
        Climber climber = new Climber();
        climbers.add(climber);
        return climbers;

    }*/
    @GetMapping(path = "{id}")
    public HAS_CLIMBED findAll(@PathVariable Long id){
        return hasClimbedService.findById(id);
    }

}
