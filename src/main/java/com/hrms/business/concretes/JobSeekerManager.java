package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.core.validation.JobSeekerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private JobSeekerValidator jobSeekerValidator;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,JobSeekerValidator jobSeekerValidator) {
        this.jobSeekerDao = jobSeekerDao;
        this.jobSeekerValidator=jobSeekerValidator;
    }


    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerDao.findAll());
    }

    @Override
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) throws Exception {

        Result result=this.jobSeekerValidator.jobSeekerCheck(jobSeeker);
        if(result.isSuccess()) {
            //doğrulamalardan geçerse kaydet.
            this.jobSeekerDao.save(jobSeeker);
        }
        return result;
    }
}
