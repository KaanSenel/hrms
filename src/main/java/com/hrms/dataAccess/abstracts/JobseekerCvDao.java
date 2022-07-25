package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobseekerCvDao extends JpaRepository<JobseekerCv, Integer> {

    JobseekerCv getById(int id);
}