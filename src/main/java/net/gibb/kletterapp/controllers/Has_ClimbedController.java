package net.gibb.kletterapp.controllers;

import net.gibb.kletterapp.models.HAS_CLIMBED;
import net.gibb.kletterapp.services.Has_ClimbedService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/climbers/{id}/has_climbed")
public class Has_ClimbedController {
 private final Has_ClimbedService hasClimbedService;

    public Has_ClimbedController(Has_ClimbedService hasClimbedService) {
        this.hasClimbedService = hasClimbedService;
    }

    @GetMapping
    public List<HAS_CLIMBED> findAll(@PathVariable Long id){
        return hasClimbedService.findAll();
    }
}
