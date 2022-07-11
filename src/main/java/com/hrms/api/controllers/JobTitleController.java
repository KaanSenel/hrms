package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobTitleService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobTitle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/title")
public class JobTitleController {

    private JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll(){
        return this.jobTitleService.getAll();
    }

    @PostMapping("/add")
    public Result add(JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }
}