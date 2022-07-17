package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobAdvertisement")
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService=jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllActive")
    public DataResult<List<JobAdvertisement>> getAllActive(){
         return this.jobAdvertisementService.getAllActive();
    }

    @PostMapping("/add")
    public Result add(JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/findByIsActiveOrderByListingDate")
    DataResult<List<JobAdvertisement>> findByIsActiveOrderByListingDateAsc(boolean active){
        return new SuccessDataResult<>
                (this.jobAdvertisementService.findByIsActiveOrderByListingDateAsc(active));
    }

    @GetMapping("/getByEmployeeCompanyNameAndIsActive")
    DataResult<List<JobAdvertisement>> getByEmployee_CompanyNameAndIsActive(String companyName,boolean active){
        return new SuccessDataResult<>
                (this.jobAdvertisementService.getByEmployee_CompanyNameAndIsActive(companyName, active));
    }
}