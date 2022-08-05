package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "level")
    private short level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_cv_id",referencedColumnName = "id")
    private JobseekerCv jobseekerCv;

}