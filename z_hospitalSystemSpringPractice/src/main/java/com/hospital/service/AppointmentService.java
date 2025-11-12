package com.hospital.service;

import java.util.List;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.AppointmentResponse;
import com.hospital.dto.BookAppointmentDTO;

public interface AppointmentService {

	List<AppointmentDTO>listUpcomingPatientAppointments(Long patientId);
	
	AppointmentResponse bookAppointment(BookAppointmentDTO bookAppointment);
}
