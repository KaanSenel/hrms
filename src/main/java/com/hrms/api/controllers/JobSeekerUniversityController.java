package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerUniversityService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getByJobseekerCvId")
    public DataResult<List<JobseekerUniversity>> getByJobseekerCvId(@RequestParam int id){
        return this.jobSeekerUniversityService.getByJobseekerCvId(id);
    }

    @GetMapping("getByJobseekerCvIdOrderByEndYearDesc")
    public DataResult<List<JobseekerUniversity>> getByJobseekerCvIdOrderByEndYearDesc(@RequestParam int id){
        return this.jobSeekerUniversityService.getByJobseekerCvIdOrderByEndYearDesc(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody JobseekerUniversity jobseekerUniversity){
        return ResponseEntity.ok(this.jobSeekerUniversityService.add(jobseekerUniversity));
    }
}
