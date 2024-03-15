package net.gibb.kletterapp.models;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node
public class Moderator {
    @Id @GeneratedValue
    private Long id;
    private Integer age;
    private String lastName;
    private String name;
    @Relationship(type = "ADMINISTERS",direction = Relationship.Direction.OUTGOING)
    private Ort moderatorOf ;


    public Moderator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ort getModeratorOf() {
        return moderatorOf;
    }

    public void setModeratorOf(Ort moderatorOf) {
        this.moderatorOf = moderatorOf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
