package com.feuji.taskmanager.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	// get the token from header
	// check the token either valid or not
	// load the user and setAuthentication
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
			String email = jwtTokenProvider.getEmailFromToken(token);
			UserDetails details = customUserDetailsService.loadUserByUsername(email);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(details,
					null, details.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			return token.substring(7, token.length());
		}
		return null;
	}
}
