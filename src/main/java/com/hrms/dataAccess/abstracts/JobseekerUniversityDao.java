package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobseekerUniversityDao extends JpaRepository<JobseekerUniversity, Integer> {

    List<JobseekerUniversity> getByJobseekerCvId(int id);
}