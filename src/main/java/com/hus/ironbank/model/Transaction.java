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
        "accountId",
        "transactionId",
        "valueDate",
        "bookingDate",
        "amount",
        "currencyCode",
        "transactionType",
        "description",
        "flow",
        "status",
        "category"
})

@Data
public class Transaction {

    @JsonProperty("companyId")
    private Integer companyId;
    @JsonProperty("bankId")
    private Integer bankId;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("valueDate")
    private String valueDate;
    @JsonProperty("bookingDate")
    private String bookingDate;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("flow")
    private String flow;
    @JsonProperty("status")
    private String status;
    @JsonProperty("category")
    private String category;
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