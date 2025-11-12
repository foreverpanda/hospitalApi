package com.hospital.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	private String message;
	private String status;
	private LocalDate timeStamp;
	
	public ApiResponse(String message, String status) {
		this.message = message;
		
		this.status= status;
		
		this.timeStamp = LocalDate.now();
	}
	
}
