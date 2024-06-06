package com.clinic.upmanyu.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto{
    private Long id;

    private String firstName;

    private String lastName;

    private String sex;

    private String aadhar;

    private int age;

    private String address;
}
