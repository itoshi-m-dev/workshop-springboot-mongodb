package com.emanuel.workshopmongo.dto;

import com.emanuel.workshopmongo.domain.User;

public class AuthorDTO {
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(User obj) {
	id = obj.getId();
	name = obj.getName();
	
	
	}
	
	

}
