package com.gagu.employee.config;


import com.gagu.employee.serviceImpl.EmployeeServiceImpl;
import com.gagu.employee.serviceImpl.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    //it will execute once per request
    @Autowired
    JWTService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Bearer + token(will receive from client need to extract the token and need to verify)
        String authHeader = request.getHeader("Authorization");
        String token =null;
        String username = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            //token will start from index 7 first 6 letters are "Bearer "
            token = authHeader.substring(7);
            username=jwtService.extractUserName(token);

        }

        //now we need to verify if token and username is correct

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = applicationContext.getBean(EmployeeServiceImpl.class).loadUserByUsername(username);

            //after verification we need to send the request to PasswordAuthentication filer and need to send the request object also
            if(jwtService.validateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken passToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                passToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(passToken);
            }

        }
        filterChain.doFilter(request, response);

    }


}
