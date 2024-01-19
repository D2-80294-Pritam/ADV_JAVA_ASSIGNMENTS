package io.bytecode.entites;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Appointment {
	@Id
	private Integer id;
	@OneToOne
	@JoinColumn (name = "patient_id")
	private Patient patient;
	@ManyToOne
	@JoinColumn (name = "doctor_id")
	private Doctor doctor;
	private LocalDate date;
	private LocalTime time;
}
