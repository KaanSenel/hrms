package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "jobseeker_cv_id",referencedColumnName = "id")
    //@JsonIgnore
    @JsonBackReference
    private JobseekerCv jobseekerCv;

    @Column(name = "company_name")
    @NotEmpty
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "position")
    @NotEmpty
    @NotNull
    @NotBlank
    private String position;

    @Column(name = "start_year")
    @NotEmpty
    @NotNull
    @NotBlank
    private String startYear;

    @Column(name = "end_year")
    private String endYear;
}