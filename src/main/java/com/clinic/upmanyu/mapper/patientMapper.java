package com.clinic.upmanyu.mapper;

import com.clinic.upmanyu.dto.PatientDto;
import com.clinic.upmanyu.entity.Patient;

public class patientMapper {

    public static PatientDto mapToPatientDto(Patient patient){
        return new PatientDto(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getSex(),
                patient.getAadhar(),
                patient.getAge(),
                patient.getAddress()
        );
    }
    public static Patient mapToPatient(PatientDto patientDto){
        return new Patient(
                patientDto.getId(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getSex(),
                patientDto.getAadhar(),
                patientDto.getAge(),
                patientDto.getAddress()
        );
    }
}
