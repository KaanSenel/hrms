package com.hrms.api.controllers;

import com.hrms.business.abstracts.CityService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService=cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }
}
