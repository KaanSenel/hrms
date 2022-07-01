package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public List<JobSeeker> getAll(){
        return this.jobSeekerService.getAll();
    }
}
