package com.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	Optional<Patient> findById(Long patientId);

	
}
