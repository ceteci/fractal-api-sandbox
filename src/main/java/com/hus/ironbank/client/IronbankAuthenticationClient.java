package com.hus.ironbank.client;

import com.hus.ironbank.model.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="account", url="${fractal.api.rootUrl}")
public interface IronbankAuthenticationClient {

    @PostMapping(value = "${fractal.api.authPath}")
    Token loginInternal(@RequestHeader("X-Partner-Id") String appId, @RequestHeader("X-Api-Key") String apiKey);

}
