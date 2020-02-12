package com.event.main.Model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attendees {

	@JsonProperty("id")
	private String id;
	@JsonProperty("profile")
	private Profile profile;
	@JsonProperty("event_id")
	private String eventId;
	@JsonProperty("order_id")
	private String orderId;
	

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