package com.hus.ironbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Token {
    @JsonProperty("access_token")
    private  String token;

    @JsonProperty("partner_name")
    private  String partnerName;

    @JsonProperty("partner_id")
    private  String partnerId;

    @JsonProperty("expires")
    private  Long expires;

    @JsonProperty("token_type")
    private  String tokenType;
}
