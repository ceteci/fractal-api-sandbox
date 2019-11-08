package com.hus.ironbank.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "createdAt",
        "yearEndMonth",
        "yearEndDay",
        "blocked",
        "registeredAddress",
        "website",
        "industry",
        "pitch",
        "currency"
})

@Data
public class Company {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("yearEndMonth")
    private Integer yearEndMonth;
    @JsonProperty("yearEndDay")
    private Integer yearEndDay;
    @JsonProperty("blocked")
    private Boolean blocked;
    @JsonProperty("registeredAddress")
    private RegisteredAddress registeredAddress;
    @JsonProperty("website")
    private String website;
    @JsonProperty("industry")
    private String industry;
    @JsonProperty("pitch")
    private String pitch;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}