package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobseekerCv;

import java.util.List;

public interface JobSeekerCvService {

    DataResult<List<JobseekerCv>> getAll();

    Result add(JobseekerCv jobseekerCv);

    JobseekerCv getById(int id);

}
