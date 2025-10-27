package com.m2i.model;

public class ClientDTO {
	private final String username;
	private final String email;
	
	public ClientDTO(String username,String email) {
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
}
