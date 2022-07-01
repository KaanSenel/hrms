package com.hrms.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "systempersonels")
@NoArgsConstructor
public class SystemPersonel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstname",length = 25)
    private String firstName;

    @Column(name = "lastname",length = 25)
    private String lastName;

    @Column(name = "jobposition",length = 50)
    private String position;
}
