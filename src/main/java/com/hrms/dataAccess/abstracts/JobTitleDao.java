package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

    JobTitle findByTitle(String title);
}