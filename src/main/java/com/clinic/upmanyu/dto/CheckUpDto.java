package com.clinic.upmanyu.dto;

import com.clinic.upmanyu.entity.CheckUp;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckUpDto {
    private Long checkUpId;
  // Reference to patient
    private String symptoms;
    private String investigation;
    private String diagnosis;
    private String treatment;
    private String investigationResults;
    private String medicine;



}
