package io.bytecode.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.bytecode.entites.Appointment;
import io.bytecode.entites.Doctor;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	List<Appointment> findByDoctor(Doctor doctor);
}
