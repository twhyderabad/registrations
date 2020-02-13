package com.event.main.Model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"text",
"html"
})
public class Name {

@JsonProperty("text")
private String text;
@JsonProperty("html")
private String html;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("text")
public String getText() {
return text;
}

@JsonProperty("text")
public void setText(String text) {
this.text = text;
}

@JsonProperty("html")
public String getHtml() {
return html;
}

@JsonProperty("html")
public void setHtml(String html) {
this.html = html;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
