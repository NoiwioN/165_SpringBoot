package net.gibb.kletterapp.services;

import io.netty.handler.codec.EncoderException;
import net.gibb.kletterapp.models.Route;
import net.gibb.kletterapp.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
    public List<Route> findAll() {
        List<Route> routes = routeRepository.findAll();
        for(Route r: routes){
            r.setClimbers(routeRepository.findClimbersByRouteId(r.getId()));
        }

        return routes;
    }
    public Route findById(Long id) {
        Route r=routeRepository.findById(id).orElseThrow(EncoderException::new);
        System.out.println(routeRepository.findClimbersByRouteId(r.getId()).get(0).getAge());
                r.setClimbers(routeRepository.findClimbersByRouteId(r.getId()));
        return r;
    }
    public void update(Route route) {
        Iterable<Route> routen = findAll();
        for (Route r : routen) {
            if (r.getId().equals(route.getId())) {
                routeRepository.save(route);
                return;
            }
        }
        throw new RuntimeException("User doesn't exist");
    }

    public void create(Route route){
        routeRepository.save(route);
    }
    public void deleteById(Long id){
        routeRepository.deleteById(id);
    }

}
