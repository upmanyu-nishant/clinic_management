package com.clinic.upmanyu.mapper;

import java.util.ArrayList;

import com.clinic.upmanyu.dto.CheckUpDto;
import com.clinic.upmanyu.dto.PatientDto;
import com.clinic.upmanyu.entity.CheckUp;
import com.clinic.upmanyu.entity.Patient;

public class PatientMapper {

    public static PatientDto mapToPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getSex(),
                patient.getAadhar(),
                patient.getAge(),
                patient.getAddress()
        );

        return patientDto;
    }

    public static Patient mapToPatient(PatientDto patientDto) {
        Patient patient = new Patient(
                patientDto.getPatientId(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getSex(),
                patientDto.getAadhar(),
                patientDto.getAge(),
                patientDto.getAddress()
        );



        return patient;
    }
}
