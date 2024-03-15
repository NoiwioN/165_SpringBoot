package net.gibb.kletterapp.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class HAS_CLIMBED {
    @Id @GeneratedValue
    private Long id;
    @TargetNode
    private final Climber climber = new Climber();
    private String review;
    private boolean isFirstAscend;
    private String suggestedGrade;
    private Double rating;

    public HAS_CLIMBED() {
    }

    public Climber getClimber() {
        return climber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSuggestedGrade() {
        return suggestedGrade;
    }

    public void setSuggestedGrade(String suggestedGrade) {
        this.suggestedGrade = suggestedGrade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public boolean isFirstAscend() {
        return isFirstAscend;
    }

    public void setFirstAscend(boolean firstAscend) {
        isFirstAscend = firstAscend;
    }
}