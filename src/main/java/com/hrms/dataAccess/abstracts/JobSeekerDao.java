package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{

}
