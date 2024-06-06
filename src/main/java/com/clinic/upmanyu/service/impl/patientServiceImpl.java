package com.clinic.upmanyu.service.impl;

import com.clinic.upmanyu.dto.PatientDto;
import com.clinic.upmanyu.entity.Patient;
import com.clinic.upmanyu.exceptions.ResourceNotFoundException;
import com.clinic.upmanyu.mapper.patientMapper;
import com.clinic.upmanyu.service.patientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinic.upmanyu.repository.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class patientServiceImpl implements patientService {
    private PatientRepository patientRepository;
    @Override
    public PatientDto createPatient(PatientDto patientDto) {

        Patient patient= patientMapper.mapToPatient(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.mapToPatientDto(savedPatient);
    }

    @Override
    public PatientDto getPatientByID(Long patientId) {
       Patient patient=  patientRepository.findById(patientId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Patient does not exist with the given id: "+ patientId));
        return patientMapper.mapToPatientDto(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients= patientRepository.findAll();
        return patients.stream().map((patient) -> patientMapper.mapToPatientDto(patient)).collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(Long patientId, PatientDto updatedPatient) {
        Patient patient= patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given id: "+ patientId)
        );

        patient.setAge(updatedPatient.getAge());
        patient.setAadhar(updatedPatient.getAadhar());
        patient.setAddress(updatedPatient.getAddress());
        patient.setSex(updatedPatient.getSex());
        patient.setLastName(updatedPatient.getLastName());
        patient.setFirstName(updatedPatient.getFirstName());

        Patient updatedPatientObj=  patientRepository.save(patient);

        return patientMapper.mapToPatientDto(updatedPatientObj);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient= patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given id: "+ patientId)
        );
        patientRepository.deleteById(patientId);
    }
}
