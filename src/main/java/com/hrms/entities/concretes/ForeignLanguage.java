package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "level")
    private short level;

    @ManyToOne
    @JoinColumn(name = "jobseeker_id")
    @JsonIgnore
    private JobSeeker jobSeeker;

}