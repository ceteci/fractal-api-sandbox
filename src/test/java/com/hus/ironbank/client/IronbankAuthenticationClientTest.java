package com.hus.ironbank.client;

import com.hus.ironbank.model.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:testApp.properties"})
class IronbankAuthenticationClientTest {

    @Value("${fractal.appId}")
    private String appId;

    @Value("${fractal.apiKey}")
    private String apiKey;

    @Autowired private IronbankAuthenticationClient ironbankAuthenticationClient;

    @Test
    void loginInternal() {
        Token token = ironbankAuthenticationClient.loginInternal(appId, apiKey);
        assertNotNull(token.getToken());
    }
}