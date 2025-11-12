package com.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.ApiResponse;
import com.hospital.dto.AuthRequest;
import com.hospital.dto.AuthResponse;
import com.hospital.service.UserService;


@RestController()
@RequestMapping("/api/v1")

public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("Inside user Controller");
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody AuthRequest authReq ) {
		System.out.println(authReq);
		try {
			System.out.println("Validating!");
			AuthResponse response = userService.signIn(authReq);
			
			return ResponseEntity.ok(response);
		}
		catch(RuntimeException e) {
			System.out.println("Error");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage(), "Failed!!"));
		}
		
	
	}
	
	
}
