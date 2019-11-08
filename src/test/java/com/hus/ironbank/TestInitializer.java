package com.hus.ironbank;

import com.hus.ironbank.client.IronbankAuthenticationClient;
import com.hus.ironbank.model.Token;
import com.hus.ironbank.client.BankApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:testApp.properties"})
@SpringBootTest
public abstract class TestInitializer {
    @Value("${fractal.appId}")
    private String appId;

    @Value("${fractal.apiKey}")
    private String apiKey;

    @Autowired private BankApiClient bankApiClient;
    @Autowired private IronbankAuthenticationClient ironbankAuthenticationClient;

    @BeforeEach
    public void init() {
        Token token = ironbankAuthenticationClient.loginInternal(appId, apiKey);
        SecurityContextHolder.setContext(new SecurityContextImpl(new UsernamePasswordAuthenticationToken(appId, token.getToken())));
    }

}
