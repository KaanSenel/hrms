package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobAdvertisement;
import com.hrms.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisementDto>> getAllActive();

    Result add(JobAdvertisement jobAdvertisement);

    List<JobAdvertisementDto> findByIsActiveOrderByListingDateAsc(boolean active);

    List<JobAdvertisementDto> getByEmployee_CompanyNameAndIsActive(String companyName,boolean active);
}