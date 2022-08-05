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
    public Result add(JobseekerCv jobseekerCv) {
        if(jobseekerCv.getJobseekerUniversities()!=null) {
            for (int i = 0; i < jobseekerCv.getJobseekerUniversities().size(); i++) {
                if (jobseekerCv.getJobseekerUniversities().get(i).getEndYear() == null) {
                    jobseekerCv.getJobseekerUniversities().get(i).
                            setEndYear("Devam ediyor");
                }
            }
        }
        if(jobseekerCv.getWorkExperiences()!=null) {
            for (int i = 0; i < jobseekerCv.getWorkExperiences().size(); i++) {
                if (jobseekerCv.getWorkExperiences().get(i).getEndYear() == null) {
                    jobseekerCv.getWorkExperiences().get(i).
                            setEndYear("Devam ediyor.");
                }
            }
        }
        this.jobseekerCvDao.save(jobseekerCv);
        return new SuccessResult("Cv Başarıyla kaydedildi.");
    }

    @Override
    public JobseekerCv getById(int id) {
        return this.jobseekerCvDao.getById(id);
    }
}