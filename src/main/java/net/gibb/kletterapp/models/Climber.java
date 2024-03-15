package net.gibb.kletterapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.neo4j.core.convert.ConvertWith;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

//TODO HAS_VISITED

@Node
public class Climber {
    @Id @GeneratedValue
    private Long id;
/*    private Integer uid;*/
    private Integer wingspan;
    private String name;
    private String proficiency;
    private String birthday;
    private Integer age;
    private Integer height;
    @Relationship(type="FRIENDS", direction = Relationship.Direction.OUTGOING)
    @JsonBackReference
    private List <Climber> friends = new ArrayList<>();
    @Relationship(type="FRIENDREQUEST_SENT", direction = Relationship.Direction.OUTGOING)
    private List <Climber> requestedFriends = new ArrayList<>();
    @Relationship(type="HAS_CLIMBED", direction = Relationship.Direction.OUTGOING)
    private List<Route> routes = new ArrayList<>();
    @Relationship(type="HAS_VISITED", direction = Relationship.Direction.OUTGOING)
    private List<Ort> visitedPlaces=new ArrayList<>();

    public Climber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ort> getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(List<Ort> visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getWingspan() {
        return wingspan;
    }

    public void setWingspan(Integer wingspan) {
        this.wingspan = wingspan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<Climber> getFriends() {
        return friends;
    }

    public void setFriends(List<Climber> friends) {
        this.friends = friends;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public List<Climber> getRequestedFriends() {
        return requestedFriends;
    }

    public void setRequestedFriends(List<Climber> requestedFriends) {
        this.requestedFriends = requestedFriends;
    }
}
