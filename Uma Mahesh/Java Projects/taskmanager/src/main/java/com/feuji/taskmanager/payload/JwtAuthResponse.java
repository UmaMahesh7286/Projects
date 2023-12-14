package com.feuji.taskmanager.payload;

import lombok.Getter;

@Getter
public class JwtAuthResponse {

	 String token;
	 String tokenType = "Bearer";

	public JwtAuthResponse(String token) {
		this.token = token;
	}

}
