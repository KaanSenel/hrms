package com.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    @JsonIgnore
    private JobSeeker jobSeeker;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "start_year")
    private String startYear;

    @Column(name = "end_year")
    private String endYear;
}