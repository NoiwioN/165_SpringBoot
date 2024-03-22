package net.gibb.kletterapp.models.relationships;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.support.DateString;

import java.util.Date;

public class FRIEND_REQUEST_SENT {
    @Id
    private Long id;
    private Long senderId;
    private Long receiverId;

    private String requestDate;

    public FRIEND_REQUEST_SENT() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
}
