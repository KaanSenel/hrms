package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobTitleService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobTitle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/title")
public class JobTitleController {

    private final JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll(){
        return this.jobTitleService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle)
    {
        return ResponseEntity.ok(this.jobTitleService.add(jobTitle));
    }
}