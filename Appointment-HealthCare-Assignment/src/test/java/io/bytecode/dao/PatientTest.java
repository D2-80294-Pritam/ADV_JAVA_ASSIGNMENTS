package io.bytecode.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import io.bytecode.entites.Patient;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PatientTest {
	
	@Autowired
	private PatientRepository dao;
	
	
	@Test
	void savePatient() {
		List<Patient> list = List.of(new Patient(1, "Rohit", 35,  "Male"), new Patient(2, "Smriti", 27, "Female"), new Patient(3, "Surya", 34, "Male"));
		List<Patient> li = dao.saveAll(list);
	}
	
	
}
