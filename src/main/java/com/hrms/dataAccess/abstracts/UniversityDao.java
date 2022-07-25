package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDao extends JpaRepository<University, Integer> {
}