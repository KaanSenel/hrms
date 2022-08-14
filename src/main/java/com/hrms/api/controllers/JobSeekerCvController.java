package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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

    @GetMapping("/getById")
    DataResult<JobseekerCv> getById(int id){
        return new SuccessDataResult<>(this.jobSeekerCvService.getById(id));
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody JobseekerCv jobseekerCv)
            throws IOException {
        return ResponseEntity.ok(this.jobSeekerCvService.add(jobseekerCv));
    }

    @PostMapping(value = "/addWithPicture", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    ResponseEntity<?> addWithPicture(@Valid @RequestBody JobseekerCv jobseekerCv,
                          @RequestPart("pictureFile") @ModelAttribute MultipartFile file)
                          throws IOException {
        return ResponseEntity.ok(this.jobSeekerCvService.addWithPicture(jobseekerCv,file));
    }

}