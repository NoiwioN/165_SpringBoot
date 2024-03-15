package net.gibb.kletterapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.types.Coordinate;

import java.util.List;

@Node
public class Route {
    @Id @GeneratedValue
    private Long id;
    private Coordinate coordinate;
    private String description;
    private String firstAscend;
    private Integer moves;
    private String name;
    private String terrain;
    @Relationship(type = "HAS_CLIMBED", direction = Relationship.Direction.INCOMING)
    @JsonBackReference

    private List<Climber> climbers;
    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstAscend() {
        return firstAscend;
    }

    public void setFirstAscend(String firstAscend) {
        this.firstAscend = firstAscend;
    }

    public Integer getMoves() {
        return moves;
    }

    public void setMoves(Integer moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public List<Climber> getClimbers() {
        return climbers;
    }
}
