package com.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.ApiResponse;
import com.hospital.dto.BookAppointmentDTO;
import com.hospital.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {

	@Autowired
	private AppointmentService appointmentService;
	
	public PatientController() {
		System.out.println("Inside PatientController");
	}
	
	@GetMapping("/{patientId}/appointments/upcoming")
	public ResponseEntity<?> listUpcomingAppointments(@PathVariable Long patientId){
		
		try {
			return ResponseEntity.ok(appointmentService.listUpcomingPatientAppointments(patientId));
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new com.hospital.dto.ApiResponse(e.getMessage(),"failed"));
		}
		
	}
	
	@PostMapping("/appointment/bookappointment")
	public ResponseEntity<?> bookAppointment(BookAppointmentDTO bookAppointment){
		System.out.println("hello");

		
		System.out.println(bookAppointment);
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bookAppointment(bookAppointment));
			
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), "Cant book appointment"));
		}
		
		
	}
	
	
}
