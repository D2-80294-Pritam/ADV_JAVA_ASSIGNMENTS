package io.bytecode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bytecode.dto.AppointmentDto;
import io.bytecode.entites.Appointment;
import io.bytecode.service.AppointmentService;

@RestController
@RequestMapping ("/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto dto) {
		System.out.println(dto.toString());
		appointmentService.bookAppointment(dto);
		return new ResponseEntity<>("Appointment scheluded", HttpStatus.CREATED);
		
	}
	@GetMapping ("/{doctorId}")
	public ResponseEntity<List<Appointment>> getAppointments(@PathVariable Integer doctorId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(appointmentService.getAppointmentsByDoctor(doctorId));
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable Integer id) {
		appointmentService.cancelAppointment(id);
		return new ResponseEntity<>("Appiontment Canceled", HttpStatus.OK);
	}
	
}
