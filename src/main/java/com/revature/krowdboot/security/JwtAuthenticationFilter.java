package com.revature.krowdboot.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.revature.krowdboot.model.JwtAuthenticationToken;


 // Filter that determines authentication by using supplied JWT token

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String tokenHeader;

    //figure out the endpoint to use
    public JwtAuthenticationFilter() {
        super("/login");
    }

    
     //Attempt to authenticate request - basically just pass over to another method

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader(this.tokenHeader);

        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("No JWT token found with correct header");
        }

        //length correlates with the startsWith above
        String authToken = header.substring(7);

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        chain.doFilter(request, response);
    }
}
