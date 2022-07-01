package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobSeeker;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{

}
