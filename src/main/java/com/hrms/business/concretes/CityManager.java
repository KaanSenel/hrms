package com.hrms.business.concretes;

import com.hrms.business.abstracts.CityService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.CityDao;
import com.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao=cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(this.cityDao.findAll());
    }
}