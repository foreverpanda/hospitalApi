package com.hospital.entities;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@AttributeOverride(name = "id" , column = @Column(name = "user_id"))
@Table(name = "users")

public class User extends BaseEntity{
	
	private LocalDate dob;
	
	@Column(length = 50)
	private String email;
	
	@Column(name = "first_name" , length = 30)
	private String firstName;
	

	@Column(name = "last_name" , length = 30)
	private String lastName;
	
	@Lob
	private byte[] image;
	
	@Column(length = 400)
	private String password;
	
	
	@Column(length = 14 , name = "phone")
	private String phone;
	
	@Column(name = "reg_amount")
	private int regAmount;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
