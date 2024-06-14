package com.clinic.upmanyu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="check_up")
public class CheckUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkUpId") // Specify the correct physical column name
    private Long checkUpId;


    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "investigation")
    private String investigation;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "investigation_results")
    private String investigationResults;

    @Column(name = "medicine")
    private String medicine;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private Patient patient;




}
