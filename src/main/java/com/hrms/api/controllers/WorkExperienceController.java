package com.hrms.api.controllers;

import com.hrms.business.abstracts.WorkExperienceService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/WorkExperience/")
public class WorkExperienceController {

    private final WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperienceController(WorkExperienceService workExperienceService){
        this.workExperienceService=workExperienceService;
    }

    @GetMapping("getAll")
    public DataResult<List<WorkExperience>> getAll(){
        return this.workExperienceService.getAll();
    }

    @GetMapping("getAllById")
    public DataResult<List<WorkExperience>> getAllById(@RequestParam int id){
        return this.workExperienceService.getByJobseekerCv_IdOrderByEndYearDesc(id);
    }
}
