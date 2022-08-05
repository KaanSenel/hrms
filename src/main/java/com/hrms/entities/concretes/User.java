package com.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email",nullable = false)
    @Email
    @NotNull
    @NotEmpty
    private String email;

    @Column(name = "password",nullable = false)
    @NotNull
    @NotEmpty
    private String password;

    @Column(name = "password", insertable = false, updatable = false)
    private String passwordAgain;

}
