package com.clinic.upmanyu.dto;

import java.util.List;

import com.clinic.upmanyu.entity.CheckUp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long patientId;
    private String firstName;
    private String lastName;
    private String sex;
    private String aadhar;
    private int age;
    private String address;


}
