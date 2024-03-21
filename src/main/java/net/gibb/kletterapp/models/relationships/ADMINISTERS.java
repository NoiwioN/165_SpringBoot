package net.gibb.kletterapp.models.relationships;

import org.springframework.data.neo4j.core.schema.Id;

public class ADMINISTERS {
    @Id
    private Long id;
    private Long ortId;
    private Long moderatorId;
    private String modMail;

    public ADMINISTERS() {
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

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public String getModMail() {
        return modMail;
    }

    public void setModMail(String modMail) {
        this.modMail = modMail;
    }
}
