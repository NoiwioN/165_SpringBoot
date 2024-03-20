package net.gibb.kletterapp.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;


public class HAS_CLIMBED {
    @Id @GeneratedValue
    private Long id;
    private Long routeId;
    private Long climberId;
    private String review;
    private boolean isFirstAscend;
    private String suggestedGrade;
    private Double rating;

    public HAS_CLIMBED() {
    }


    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }


    public Long getClimberId() {
        return climberId;
    }

    public void setClimberId(Long climberId) {
        this.climberId = climberId;
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
