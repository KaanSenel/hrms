package com.hrms.business.abstracts;

import com.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    List<JobSeeker> getAll();
}
