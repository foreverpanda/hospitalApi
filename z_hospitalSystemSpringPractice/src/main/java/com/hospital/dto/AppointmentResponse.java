package com.hospital.dto;

import java.time.LocalDateTime;

import com.hospital.entities.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentResponse {
	
	private Long appointmentId;
	private String doctorFirstName;
	private String doctorLastName;
	private LocalDateTime appointmentDateTime;
	private Status status;
	private String message;
	
}
