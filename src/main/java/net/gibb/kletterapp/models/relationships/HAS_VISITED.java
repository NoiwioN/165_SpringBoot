package net.gibb.kletterapp.models.relationships;

import org.springframework.data.neo4j.core.schema.Id;

public class HAS_VISITED {
    @Id
    private Long id;
    private long climberId;
    private long ortIt;

    public HAS_VISITED() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getClimberId() {
        return climberId;
    }

    public void setClimberId(long climberId) {
        this.climberId = climberId;
    }

    public long getOrtIt() {
        return ortIt;
    }

    public void setOrtIt(long ortIt) {
        this.ortIt = ortIt;
    }
}
