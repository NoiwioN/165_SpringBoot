package net.gibb.kletterapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.driver.types.Point;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;


@Node
public class Ort {
    @Id
    private Long id;
    private Point address;
    private String goodConditionsEnd;
    private String goodConditionsStart;
    private String name;
    @Relationship(type = "HAS_VISITED", direction = Relationship.Direction.INCOMING)
    @JsonBackReference
    private List<Climber> visitedBy = new ArrayList<>();
    @Relationship(type="LOCATED_IN",direction = Relationship.Direction.INCOMING)
    @JsonBackReference
    private List<Route> routes= new ArrayList<>();
    @Relationship (type = "ADMINISTERS", direction = Relationship.Direction.INCOMING)
    @JsonBackReference
    private Moderator moderator;

    public Ort() {
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Climber> getVisitedBy() {
        return visitedBy;
    }

    public void setVisitedBy(List<Climber> visitedBy) {
        this.visitedBy = visitedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getAddress() {
        return address;
    }

    public void setAddress(Point address) {
        this.address = address;
    }

    public String getGoodConditionsEnd() {
        return goodConditionsEnd;
    }

    public void setGoodConditionsEnd(String goodConditionsEnd) {
        this.goodConditionsEnd = goodConditionsEnd;
    }

    public String getGoodConditionsStart() {
        return goodConditionsStart;
    }

    public void setGoodConditionsStart(String goodConditionsStart) {
        this.goodConditionsStart = goodConditionsStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
