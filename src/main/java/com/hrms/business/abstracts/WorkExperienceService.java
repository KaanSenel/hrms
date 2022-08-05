package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {

    DataResult<List<WorkExperience>> getByJobseekerCv_IdOrderByEndYearDesc(int id);

    DataResult<List<WorkExperience>> getAll();
}
