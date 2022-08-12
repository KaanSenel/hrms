package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})
public class ForeignLanguage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    @NotEmpty
    @NotNull
    private String language;

    @Column(name = "level")
    @Min(1)
    @Max(5)
    private short level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_cv_id",referencedColumnName = "id")
    @JsonBackReference
    private JobseekerCv jobseekerCv;

}