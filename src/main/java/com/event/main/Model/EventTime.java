package com.event.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTime {

    @JsonProperty("local")
    private Date local;
    @JsonProperty("utc")
    private Date utc;

    public void setLocal(Date local) {
        this.local = local;
    }

    public void setUtc(Date utc) {
        this.utc = utc;
    }

    public Date getLocal() {
        return local;
    }

    public Date getUtc() {
        return utc;
    }
}
