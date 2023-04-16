package com.masai.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class JwtTokenGeneratorFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("inside doFilter....");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
        	
        	System.out.println("authenticationnnn "+authentication);
        	
        	
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());
            
            
            String jwt = Jwts.builder()
            		.setIssuer("user")
            		.setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("role",getRole(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime()+ 30000000)) // expiration time of 8 hours
                    .signWith(key).compact();
            
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
 
        
        }

        filterChain.doFilter(request, response);
    	
		
		
	}
	
	
	  private String getRole(Collection<? extends GrantedAuthority> collection) {
	        
	    String role="";
		  for(GrantedAuthority ga:collection) {
			  role= ga.getAuthority();
		  }
	    
		  return role;
	    }
		
	
		
		
		
	
//this make sure that this filter will execute only for first time when client call the api /login at first time
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
	
        return !request.getServletPath().equals("/signIn");	
	}
}
