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
        "bankId",
        "accountId",
        "companyId",
        "transactionId",
        "bookingDate",
        "description",
        "amount",
        "currencyCode",
        "type"
})

@Data
public class BankTransaction {

    @JsonProperty("bankId")
    private Integer bankId;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("companyId")
    private Integer companyId;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("bookingDate")
    private String bookingDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("type")
    private String type;
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