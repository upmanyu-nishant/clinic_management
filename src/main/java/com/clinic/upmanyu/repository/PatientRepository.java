package com.clinic.upmanyu.repository;

import com.clinic.upmanyu.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long > {
}
