package com.event.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Attendees")
public class Attendees {

    @JsonProperty("id")
    private String id;
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("attendance")
    private Boolean Attendance;

    @JsonProperty("attendance")
    public Boolean getAttendance() {
        return Attendance;
    }

    @JsonProperty("attendance")
    public void setAttendance(Boolean attendance) {
        Attendance = attendance;
    }


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonProperty("event_id")
    public String getEventId() {

        return eventId;
    }

    @JsonProperty("event_id")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
