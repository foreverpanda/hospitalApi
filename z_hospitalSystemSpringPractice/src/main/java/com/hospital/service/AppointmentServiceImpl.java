package com.hospital.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.custom_exceptions.ResourceNotFoundException;
import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.AppointmentResponse;
import com.hospital.dto.BookAppointmentDTO;
import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.hospital.entities.Status;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppointmentServiceImpl implements AppointmentService {


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;



	@Override
	public List<AppointmentDTO> listUpcomingPatientAppointments(Long patientId) {

		List<AppointmentDTO> list = appointmentRepository.getPatientUpcomingAppointmentsByPatientID(patientId,
				Status.SCHEDULED);

		return list;
	}

	@Override
	public AppointmentResponse bookAppointment(BookAppointmentDTO bookAppointment) {
		System.out.println("Booking appointment!!");
		System.out.println(bookAppointment);
		Patient patient = patientRepository.findById(bookAppointment.getPatientId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Patient Id!!"));

		Doctor doctor = doctorRepository.findById(bookAppointment.getDoctorId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Doctor Id!!"));

		Appointment newAppointment = new Appointment();

		if (!appointmentRepository.existsByDoctorIdAndAppointmentDateTime(bookAppointment.getDoctorId(),
				bookAppointment.getAppointmentDateTime())) {
			newAppointment.setAppointmentDateTime(bookAppointment.getAppointmentDateTime());
			newAppointment.setDoctor(doctor);
			newAppointment.setPatient(patient);
			newAppointment.setActive(true);
			newAppointment.setStatus(Status.SCHEDULED);

			Appointment entity = appointmentRepository.save(newAppointment);

			AppointmentResponse respDto = new AppointmentResponse(entity.getId(),
					entity.getDoctor().getUser().getFirstName(), entity.getDoctor().getUser().getLastName(),
					entity.getAppointmentDateTime(), Status.SCHEDULED, "Booking Succesful!!");
			return respDto;
		}
		else {
			throw new ResourceNotFoundException("appointment unabvalai");
		}
		

	}

}
