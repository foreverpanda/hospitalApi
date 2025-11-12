package com.hospital.entities;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "user")
@AttributeOverride(name = "id" , column=@Column(name = "doctor_id"))
public class Doctor extends BaseEntity{

	
	
	@Column(name = "experience_in_years")
	private int experienceInYears;
	
	private int fees;
	
	@Column(length = 255)
	private String qualifications;
	
	@Column(length = 100)
	private String speciality;
	
	@JoinColumn(name = "userId" ,nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	
}
