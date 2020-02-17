package com.event.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Platform {

    @JsonProperty("platform_name")
    private String platformName;
    @JsonProperty("platform_event_id")
    private String platformEventId;

    public Platform(String platformName, String platformEventId) {
        this.platformName = platformName;
        this.platformEventId = platformEventId;
    }

    @JsonProperty("platform_name")
    public String getPlatformName() {
        return platformName;
    }

    @JsonProperty("platform_event_id")
    public String getPlatformEventId() {
        return platformEventId;
    }

    @JsonProperty("platform_name")
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @JsonProperty("platform_event_id")
    public void setPlatformEventId(String platformEventId) {
        this.platformEventId = platformEventId;
    }
}
