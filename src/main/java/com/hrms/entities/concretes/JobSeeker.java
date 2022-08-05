package com.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class JobSeeker extends User {


    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "identity_number",nullable = false)
    private String identityNumber;

    @Column(name = "birth_year",nullable = false)
    private int yearOfBirth;
}
