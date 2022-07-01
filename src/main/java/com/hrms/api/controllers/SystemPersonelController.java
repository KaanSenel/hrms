package com.hrms.api.controllers;

import com.hrms.business.abstracts.SystemPersonelService;
import com.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personel")
public class SystemPersonelController {

    private SystemPersonelService systemPersonelService;

    @Autowired
    public SystemPersonelController(SystemPersonelService systemPersonelService) {
        this.systemPersonelService = systemPersonelService;
    }

    @GetMapping("/getall")
    public List<SystemPersonel> getAll(){
        return this.systemPersonelService.getAllPersonels();
    }


    /* GetMapping anotasyonunda name parametresini yazma çalışmıyor */

    @GetMapping("/getallpositions")
    public List<String> getAllPositions(){
        return this.systemPersonelService.getAllPositions();
    }

/*
    @PostMapping("/add")
    public Result add(Product product){
        return this.productService.add(product);
    }

 */

}
