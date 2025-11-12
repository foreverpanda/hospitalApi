package com.hospital.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patients")
@AttributeOverride(name = "id", column = @Column(name = "patient_id"))
public class Patient extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(name = "blood_group")
	private BloodGroup bloodGroup;
	
	@Column(name = "family_history" , length = 500)
	private String familyHistory;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "user_id")
	private User user;
	
}
