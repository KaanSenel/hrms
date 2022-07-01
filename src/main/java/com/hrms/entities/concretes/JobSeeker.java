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
@Table(name = "jobSeekers")
public class JobSeeker extends User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "firstName", length = 25,nullable = false)
    private String firstName;

    @Column(name = "lastName",length = 25,nullable = false)
    private String lastName;

    @Column(name = "identityNo",length = 11,nullable = false)
    private long identityNo;

    @Column(name = "yearOfBirthday",nullable = false)
    private short yearOfBirth;
}
