package com.hrms.api.controllers;

import com.hrms.business.abstracts.WorkExperienceService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.ErrorDataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("getByJobseekerCvIdOrderByEndYearDesc")
    public DataResult<List<WorkExperience>> getByJobseekerCv_IdOrderByEndYearDesc(@RequestParam int id){
        return this.workExperienceService.getByJobseekerCvIdOrderByEndYearDesc(id);
    }

    @GetMapping("getByJobseekerCvId")
    public DataResult<List<WorkExperience>> getByJobseekerCvId(@RequestParam int id){
        return this.workExperienceService.getByJobseekerCvId(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody WorkExperience workExperience){
        return ResponseEntity.ok(this.workExperienceService.add(workExperience));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException exception){
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((err)->{
            String field=((FieldError) err).getField();
            String message=err.getDefaultMessage();
            errors.put(field,message);
        });
        return new ErrorDataResult<>(errors);
    }
}