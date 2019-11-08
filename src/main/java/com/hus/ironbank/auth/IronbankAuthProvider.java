package com.hus.ironbank.auth;

import com.hus.ironbank.client.IronbankAuthenticationClient;
import com.hus.ironbank.model.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class IronbankAuthProvider implements AuthenticationProvider {

    private IronbankAuthenticationClient ironbankAuthenticationClient;
    private String apiKey;
    private String appId;

    public IronbankAuthProvider(IronbankAuthenticationClient ironbankAuthenticationClient,
                                @Value("${fractal.appId}") String appId,
                                @Value("${fractal.apiKey}") String apiKey
                                ) {
        this.ironbankAuthenticationClient = ironbankAuthenticationClient;
        this.appId = appId;
        this.apiKey = apiKey;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication.isAuthenticated()) {
            return authentication;
        }

        try {
            Token token = ironbankAuthenticationClient.loginInternal(appId, apiKey);
            return new UsernamePasswordAuthenticationToken(appId, token.getToken(), Collections.singleton(new SimpleGrantedAuthority("USER")));
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
