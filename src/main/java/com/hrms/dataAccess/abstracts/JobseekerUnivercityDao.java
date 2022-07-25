package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobseekerUnivercityDao extends JpaRepository<JobseekerUniversity, Integer> {
}