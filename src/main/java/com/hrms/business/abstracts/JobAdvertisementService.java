package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllActive();

    Result add(JobAdvertisement jobAdvertisement);

    List<JobAdvertisement> findByIsActiveOrderByListingDateAsc(boolean active);

    List<JobAdvertisement> getByEmployee_CompanyNameAndIsActive(String companyName,boolean active);
}