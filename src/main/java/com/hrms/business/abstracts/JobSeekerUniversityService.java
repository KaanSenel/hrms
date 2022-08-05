package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.entities.concretes.JobseekerUniversity;

import java.util.List;

public interface JobSeekerUniversityService {

    DataResult<List<JobseekerUniversity>> getByJobseekerCvId(int id);

    DataResult<List<JobseekerUniversity>> getAll();
}
