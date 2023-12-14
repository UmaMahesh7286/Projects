package com.feuji.taskmanager.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.feuji.taskmanager.exception.ApiException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	public String generatetoken(Authentication authentication) {
		String email = authentication.getName();
		Date currentDate = new Date();
		Date experiedDate = new Date(currentDate.getTime()+ 1000 * 60 * 60*24); // 24 hours

		String token = Jwts.builder().setSubject(email).setIssuedAt(currentDate).setExpiration(experiedDate)
				.signWith(SignatureAlgorithm.HS512, "JWTSecretKey").compact();
		return token;
	}

	public String getEmailFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey("JWTSecretKey").parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey("JWTSecretKey")
			.parseClaimsJws(token);
			return true;
		}
		catch(Exception e) {
			throw new ApiException("token issue"+e.getMessage());
		}
	}
}
