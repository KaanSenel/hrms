package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerUniversityService;
import com.hrms.core.results.DataResult;
import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/JobSeekerUniversity/")
public class JobSeekerUniversityController {

    private final JobSeekerUniversityService jobSeekerUniversityService;

    @Autowired
    public JobSeekerUniversityController(JobSeekerUniversityService jobSeekerUniversityService){
        this.jobSeekerUniversityService=jobSeekerUniversityService;
    }

    @GetMapping("getAll")
    public DataResult<List<JobseekerUniversity>> getAll(){
        return this.jobSeekerUniversityService.getAll();
    }

    @GetMapping("getAllById")
    public DataResult<List<JobseekerUniversity>> getAllById(@RequestParam int id){
        return this.jobSeekerUniversityService.getByJobseekerCvId(id);
    }
}
