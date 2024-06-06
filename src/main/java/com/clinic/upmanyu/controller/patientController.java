package com.clinic.upmanyu.controller;

import com.clinic.upmanyu.dto.PatientDto;
import com.clinic.upmanyu.service.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class patientController {

    private patientService  patientService;

    @Autowired
    public patientController(patientService patientService) {
        this.patientService = patientService;
    }
    //add patient rest API
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        PatientDto savedPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    //get patient rest API
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id")Long patientId){
        PatientDto patientDto= patientService.getPatientByID(patientId);
        return ResponseEntity.ok(patientDto);
    }

    //get all patients
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List<PatientDto> patients= patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    //update patient by id
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long patientId, @RequestBody PatientDto updatedPatient){
        PatientDto patientDto= patientService.updatePatient(patientId,updatedPatient);
        return ResponseEntity.ok(patientDto);
    }

}
