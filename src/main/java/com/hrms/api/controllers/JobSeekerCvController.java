package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.ErrorDataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    ResponseEntity<?> add(@Valid @RequestBody JobseekerCv jobseekerCv){
        return ResponseEntity.ok(this.jobSeekerCvService.add(jobseekerCv));
    }

}
