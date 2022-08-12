package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {

    DataResult<List<WorkExperience>> getByJobseekerCvIdOrderByEndYearDesc(int id);

    DataResult<List<WorkExperience>> getAll();

    Result add(WorkExperience workExperience);

    DataResult<List<WorkExperience>> getByJobseekerCvId(int id);
}
