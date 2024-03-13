package net.gibb.kletterapp.models;

import org.neo4j.driver.types.Point;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Node
public class Ort {
    @Id @GeneratedValue
    private Long id;
    private Point address;
    private String goodConditionsEnd;
    private String goodConditionsStart;
    private String name;

    public Ort() {
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
