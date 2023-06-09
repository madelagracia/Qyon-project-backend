package com.qyon.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import java.io.IOException;
import java.util.ArrayList;

public class JWTValidateFilter extends BasicAuthenticationFilter {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";

    public JWTValidateFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        String attribute = request.getHeader(HEADER_AUTHORIZATION);

        if (attribute == null) {
            chain.doFilter(request, response);
            return;
        }
 
        if (!attribute.startsWith(BEARER)) {
            chain.doFilter(request, response);
            return;
        }

        String token = attribute.replace(BEARER, "");
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

        String userData = JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.TOKEN_GUID))
                .build()
                .verify(token)
                .getSubject();

        if (userData == null) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(userData, null, new ArrayList<>());
    }
}