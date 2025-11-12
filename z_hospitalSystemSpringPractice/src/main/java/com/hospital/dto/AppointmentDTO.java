package com.hospital.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
	
	private Long id;
	private LocalDateTime appointmentDateTime;
	private String doctorfirstName;
	private String doctorLastName;
	
	
}
