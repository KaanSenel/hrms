package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
}