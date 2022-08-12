package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobseekerCvDao extends JpaRepository<JobseekerCv, Integer> {

    @Query("From JobseekerCv where id=:id")
    JobseekerCv getById(int id);
}