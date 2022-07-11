package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class JobSeeker extends User {

   // @Column(name = "id")
  //  private int id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "identity_number",nullable = false)
    private String identityNumber;

    @Column(name = "birth_year",nullable = false)
    private int yearOfBirth;
}
