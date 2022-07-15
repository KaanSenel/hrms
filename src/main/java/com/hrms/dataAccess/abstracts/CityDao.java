package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer> {

    boolean existsByCity(String city);

    City findByCity(String city);
}