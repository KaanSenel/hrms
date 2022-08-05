package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobSeekerCv")
public class JobSeekerCvController {

    private final JobSeekerCvService jobSeekerCvService;

    @Autowired
    public JobSeekerCvController(JobSeekerCvService jobSeekerCvService){
        this.jobSeekerCvService=jobSeekerCvService;
    }

    @GetMapping("/getAll")
    DataResult<List<JobseekerCv>> getAll(){
        return this.jobSeekerCvService.getAll();
    }

    @GetMapping
    DataResult<JobseekerCv> getById(int id){
        return new SuccessDataResult<>(this.jobSeekerCvService.getById(id));
    }

    @PostMapping("/add")
    Result add(/*@Valid*/ @RequestBody JobseekerCv jobseekerCv){
        return this.jobSeekerCvService.add(jobseekerCv);
    }

}
