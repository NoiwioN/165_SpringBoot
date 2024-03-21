package net.gibb.kletterapp.models.relationships;

import org.springframework.data.neo4j.core.schema.Id;

public class HAS_VISITED {
    @Id
    private Long id;
    private Long climberId;
    private Long ortId;
    private Integer times;

    public HAS_VISITED() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClimberId() {
        return climberId;
    }

    public void setClimberId(Long climberId) {
        this.climberId = climberId;
    }

    public Long getOrtId() {
        return ortId;
    }

    public void setOrtId(Long ortId) {
        this.ortId = ortId;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
