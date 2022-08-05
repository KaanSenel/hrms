package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "minimum_salary")
    private int minSalary;

    @Column(name = "maximum_salary")
    private int maxSalary;

    @Column(name = "open_positions")
    private int openPositions;

    @Column(name = "listing_date")
    private LocalDateTime listingDate=LocalDateTime.now();

    @Column(name = "app_deadline")
    private LocalDate appDeadline;

    @Column(name = "is_active")
    private boolean isActive;

}