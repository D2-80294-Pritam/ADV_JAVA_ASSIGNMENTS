package io.bytecode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.bytecode.entites.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
