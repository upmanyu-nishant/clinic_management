package com.clinic.upmanyu.service;

import com.clinic.upmanyu.dto.PatientDto;

import java.util.List;

public interface patientService {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto getPatientByID( Long patientId);

    List<PatientDto> getAllPatients();
    PatientDto updatePatient(Long patientId, PatientDto updatedPatient);

    void deletePatient(Long patientId);
}
