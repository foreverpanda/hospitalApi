package com.hospital.dto;

import com.hospital.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;
	private String message;
	
}
