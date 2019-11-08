package com.hus.ironbank.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class IronbankAuthRequestInterceptor implements RequestInterceptor {

    @Value("${fractal.appId}")
    private String appId;

    @Value("${fractal.apiKey}")
    private String apiKey;

    private String authPath;

    public IronbankAuthRequestInterceptor(@Value("${fractal.api.authPath}") String authPath) {
        this.authPath = authPath;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //auth request
        if(authPath.equals(requestTemplate.url())) {
            return;
        }

        String authToken = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        String authHeader = String.format("Bearer %s", authToken);
        requestTemplate.header(HttpHeaders.AUTHORIZATION, authHeader);
        requestTemplate.header("X-Partner-Id", appId);
        requestTemplate.header("X-Api-Key", apiKey);
    }
}
