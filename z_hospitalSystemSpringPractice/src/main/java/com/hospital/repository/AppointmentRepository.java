package com.hospital.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.dto.AppointmentDTO;
import com.hospital.entities.Appointment;
import com.hospital.entities.Status;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("""


						select new com.hospital.dto.AppointmentDTO(a.id,a.appointmentDateTime,
						a.doctor.user.firstName,a.doctor.user.lastName) 
						from appointments a where a.patient.id=:pid and a.status=:sts order by a.appointmentDateTime asc

			""")
	
	
	List<AppointmentDTO> getPatientUpcomingAppointmentsByPatientID(@Param("pid") Long patientId,
			@Param("sts") Status status);
	
	
	Boolean existsByDoctorIdAndAppointmentDateTime(Long doctorId, LocalDateTime appointmentDateTime);

}
