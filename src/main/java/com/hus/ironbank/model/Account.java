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
        "companyId",
        "bankId",
        "currency",
        "AccountId",
        "Account",
        "dateAuthorised",
        "revoked"
})

@Data
public class Account {

    @JsonProperty("companyId")
    private Integer companyId;
    @JsonProperty("bankId")
    private Integer bankId;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("Account")
    private AccountDetails account;
    @JsonProperty("dateAuthorised")
    private String dateAuthorised;
    @JsonProperty("revoked")
    private Boolean revoked;
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