package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobTitleService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.validation.JobTitleValidator;
import com.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.entities.concretes.JobTitle;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;
    private JobTitleValidator jobTitleValidator;

    public JobTitleManager(JobTitleDao jobTitleDao,JobTitleValidator jobTitleValidator) {
        this.jobTitleDao = jobTitleDao;
        this.jobTitleValidator=jobTitleValidator;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<>(this.jobTitleDao.findAll());
    }

    @Override
    public Result add(@RequestBody JobTitle jobTitle) {
        Result result=this.jobTitleValidator.jobTitleCheck(jobTitle);
        if(result.isSuccess()){
            this.jobTitleDao.save(jobTitle);
        }
        return result;
    }
}
