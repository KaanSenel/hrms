package com.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobseeker_cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobseekerCv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne()
    @JoinColumn(name = "jobseeker_id", nullable = false)
    @JsonIgnore
    private JobSeeker jobseekerId;

    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_university_id", nullable = false)
    private List<JobseekerUniversity> jobseekerUnivercityId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_experience_id", nullable = false)
    private List<WorkExperience> workExperienceId;

    @ManyToOne
    @JoinColumn(name = "foreign_language_id", nullable = false)
    private List<ForeignLanguage> foreignLanguageId;

     */

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "programing_languages", length = 1000)
    private String programingLanguages;

    @Lob
    @Column(name = "cover_letter")
    private String coverLetter;

}