package com.hrms.api.controllers;

import com.hrms.business.abstracts.ForeignLanguageService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/foreignLanguage/")
public class ForeignLanguageController {

    private final ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguageController(ForeignLanguageService foreignLanguageService){
        this.foreignLanguageService=foreignLanguageService;
    }

    @GetMapping("getAll")
    DataResult<List<ForeignLanguage>> getAll(){
        return this.foreignLanguageService.getAll();
    }

    @GetMapping("getByJobseekerCvId")
    DataResult<List<ForeignLanguage>> getByJobseekerCvId(@RequestParam int id){
        return this.foreignLanguageService.getByJobseekerCvId(id);
    }

    @PostMapping("add")
    ResponseEntity<?> add(@Valid @RequestBody ForeignLanguage foreignLanguage){
       return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));
    }
}
