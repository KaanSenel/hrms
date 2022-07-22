package com.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

    //dto sonra değiştirilebilir companyName ve jobTitle kısımları String
    // veri tipi değil nesne veri tipi verilebilir emin değilim ondan.

    private int id;

    private String companyName;

    private String jobTitle;

    private int openPositions;

    private LocalDateTime listingDate;

    private LocalDate appDeadline;
}
