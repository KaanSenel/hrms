package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    /*
        null hatası nesne üretilemediği için mi acaba post işlemine yarın videolardan bi göz gezdir.
     */
    private JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public Result add(JobSeeker jobSeeker) throws Exception {
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }

}
