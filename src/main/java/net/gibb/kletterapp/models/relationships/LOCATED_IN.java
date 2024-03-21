package net.gibb.kletterapp.models.relationships;

import org.springframework.data.neo4j.core.schema.Id;

public class LOCATED_IN {
    @Id
    private Long id;
    private Long ortId;
    private Long routeId;
    private Integer distance;

    public LOCATED_IN() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrtId() {
        return ortId;
    }

    public void setOrtId(Long ortId) {
        this.ortId = ortId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
