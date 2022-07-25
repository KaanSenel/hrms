package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobseekerCvDao;
import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobSeekerCvManager implements JobSeekerCvService {

    private final JobseekerCvDao jobseekerCvDao;

    @Autowired
    public JobSeekerCvManager(JobseekerCvDao jobseekerCvDao){
        this.jobseekerCvDao=jobseekerCvDao;
    }

    @Override
    public DataResult<List<JobseekerCv>> getAll() {
        return new SuccessDataResult<>(this.jobseekerCvDao.findAll(),
                "Cv verileri getirildi.");
    }

    @Override
    public Result add(@RequestBody JobseekerCv jobseekerCv) {
        this.jobseekerCvDao.save(jobseekerCv);
        return new SuccessResult("Cv Başarıyla kaydedildi.");
    }

    @Override
    public JobseekerCv getById(int id) {
        return this.jobseekerCvDao.getById(id);
    }
}