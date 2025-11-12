package com.hospital.dto;

import java.time.LocalDateTime;

import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.hospital.entities.Status;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BookAppointmentDTO {

	private LocalDateTime appointmentDateTime;
	private Status status= Status.SCHEDULED;
	private Long doctorId;
	private Long patientId;
	
	
}
