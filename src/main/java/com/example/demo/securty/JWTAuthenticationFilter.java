package com.example.demo.securty;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter implements OncePerRequestFilter {

    private JWTGenerator jwtGenerator;
    private CustomUserDetailService customUserDetailService;

    @Autowired
    public JWTAuthenticationFilter(JWTGenerator jwtGenerator, CustomUserDetailService customUserDetailService) {
        this.jwtGenerator = jwtGenerator;
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = JWTFromRequest(request);
        if(StringUtils.hasText(token) && jwtGenerator.validateToken(token)){
            String username = jwtGenerator.getusernamefromjwt(token);
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);


        }
    }

    private String JWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());

        }
        return null;
    }
}
