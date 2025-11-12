package com.hospital.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "diagnostic_tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "diagnostic_test_id"))
public class DiagnosticTest extends BaseEntity {

	@Column(length = 500)
	private String description;

	@Column(length = 100)
	private String name;

	private int price;

}
