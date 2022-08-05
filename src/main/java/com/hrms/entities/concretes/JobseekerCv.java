package com.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobseeker_cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler",/*"jobseekerUniversities","workExperiences","foreignLanguages"*/})
public class JobseekerCv {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToOne()
    @JoinColumn(name = "jobseeker_id", nullable = false)
    private JobSeeker jobseekerId;

    @OneToMany(mappedBy = "jobseekerCv",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<JobseekerUniversity> jobseekerUniversities;

    @OneToMany(mappedBy = "jobseekerCv",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "jobseekerCv",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ForeignLanguage> foreignLanguages;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "programing_languages", length = 1000)
    private String programingLanguages;

    @Column(name = "cover_letter")
    @NotNull
    @NotEmpty
    private String coverLetter;

}