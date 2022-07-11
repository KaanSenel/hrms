package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobTitle;
import java.util.List;

public interface JobTitleService {

    public DataResult<List<JobTitle>> getAll();

    Result add(JobTitle jobTitle);

}
