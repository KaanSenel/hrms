package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobAdvertisement;
import com.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
    https://www.baeldung.com/spring-data-sorting
 */

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    @Query("select j from JobAdvertisement j where j.isActive = true")
    List<JobAdvertisementDto> getByIsActive();

    List<JobAdvertisementDto> findByIsActiveOrderByListingDateAsc(boolean active);

    List<JobAdvertisementDto> getByEmployee_CompanyNameAndIsActive(String companyName,boolean active);

}