package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobSeekerUniversityService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobseekerUniversityDao;
import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobSeekerUniversityManager implements JobSeekerUniversityService {

    private final JobseekerUniversityDao jobseekerUniversityDao;

    @Autowired
    public JobSeekerUniversityManager(JobseekerUniversityDao jobseekerUniversityDao) {
        this.jobseekerUniversityDao = jobseekerUniversityDao;
    }


    @Override
    public DataResult<List<JobseekerUniversity>> getByJobseekerCvId(int id) {
        return new SuccessDataResult<>(this.jobseekerUniversityDao.getByJobseekerCv_Id(id));
    }

    @Override
    public DataResult<List<JobseekerUniversity>> getAll() {
        return new SuccessDataResult<>
                (this.jobseekerUniversityDao.findAll(),
                        "Veriler getirildi.");
    }

    @Override
    public DataResult<List<JobseekerUniversity>> getByJobseekerCvIdOrderByEndYearDesc(int id) {
        return new SuccessDataResult<>
                (this.jobseekerUniversityDao.getByJobseekerCvIdOrderByEndYearDesc(id),
                        "Veriler getirildi.");
    }

    @Override
    public Result add(JobseekerUniversity jobseekerUniversity) {
        if(jobseekerUniversity.getEndYear()==null){
            jobseekerUniversity.setEndYear("Devam Ediyor.");
        }
        this.jobseekerUniversityDao.save(jobseekerUniversity);
        return new SuccessResult("Üniversite bilgisi kaydedildi.");
    }
}
