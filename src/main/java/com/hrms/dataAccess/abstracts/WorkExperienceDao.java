package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.WorkExperience;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

    List<WorkExperience> getByJobseekerCv_IdOrderByEndYearDesc(int id);
}