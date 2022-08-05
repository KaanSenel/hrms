package com.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","job_advertisements"})
public class Employee extends User{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

}
