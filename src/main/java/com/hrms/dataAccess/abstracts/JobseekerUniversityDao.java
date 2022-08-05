package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobseekerUniversityDao extends JpaRepository<JobseekerUniversity,Integer> {
    List<JobseekerUniversity> getByJobseekerCv_Id(int id);

    List<JobseekerUniversity> getByJobseekerCvIdOrderByEndYearDesc(int id);

}
