package io.bytecode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.bytecode.entites.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
}
