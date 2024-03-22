package net.gibb.kletterapp.models.relationships;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class FRIENDS {
    @Id
    private Long id;
    private Long climberOneId;
    private Long climberTwoId;
    private String since;

    public FRIENDS() {
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClimberOneId() {
        return climberOneId;
    }

    public void setClimberOneId(Long climberOneId) {
        this.climberOneId = climberOneId;
    }

    public Long getClimberTwoId() {
        return climberTwoId;
    }

    public void setClimberTwoId(Long climberTwoId) {
        this.climberTwoId = climberTwoId;
    }
}
