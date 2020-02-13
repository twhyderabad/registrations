package com.event.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "id", "url", "organization_id", "created", "changed", "published", "capacity",
		"capacity_is_custom", "status" })
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Event")
public class Event{

	@JsonProperty("name")
	private Name name;
	@JsonProperty("id")
	private String id;
	@JsonProperty("url")
	private String url;
	@JsonProperty("organization_id")
	private String organizationId;
	@JsonProperty("created")
	private String created;
	@JsonProperty("changed")
	private String changed;
	@JsonProperty("published")
	private String published;
	@JsonProperty("capacity")
	private Integer capacity;
	@JsonProperty("capacity_is_custom")
	private Boolean capacityIsCustom;
	@JsonProperty("status")
	private String status;
	@JsonProperty("platforms")
	private List<Platform> platforms;


	@JsonProperty("name")
	public Name getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(Name name) {
		this.name = name;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("organization_id")
	public String getOrganizationId() {
		return organizationId;
	}

	@JsonProperty("organization_id")
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}

	@JsonProperty("changed")
	public String getChanged() {
		return changed;
	}

	@JsonProperty("changed")
	public void setChanged(String changed) {
		this.changed = changed;
	}

	@JsonProperty("published")
	public String getPublished() {
		return published;
	}

	@JsonProperty("published")
	public void setPublished(String published) {
		this.published = published;
	}

	@JsonProperty("capacity")
	public Integer getCapacity() {
		return capacity;
	}

	@JsonProperty("capacity")
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@JsonProperty("capacity_is_custom")
	public Boolean getCapacityIsCustom() {
		return capacityIsCustom;
	}

	@JsonProperty("capacity_is_custom")
	public void setCapacityIsCustom(Boolean capacityIsCustom) {
		this.capacityIsCustom = capacityIsCustom;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}



}
