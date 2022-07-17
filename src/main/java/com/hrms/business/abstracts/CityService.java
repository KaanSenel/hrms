package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();


}
