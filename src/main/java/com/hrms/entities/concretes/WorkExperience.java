package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_cv_id")
    @JsonIgnore
    private JobseekerCv jobseekerCv;

    @Column(name = "company_name")
    @NotEmpty
    @NotNull
    private String companyName;

    @Column(name = "position")
    @NotEmpty
    @NotNull
    private String position;

     @Column(name = "start_year")
    @NotEmpty
    @NotNull
    private String startYear;

    @Column(name = "end_year")
    private String endYear;
}