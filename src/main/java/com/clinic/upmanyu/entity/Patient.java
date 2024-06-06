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
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="sex")
    private String sex;
    @Column(name="aadhar")
    private String aadhar;
    @Column(name="age")
    private int age;
    @Column(name="address")
    private String address;
}
