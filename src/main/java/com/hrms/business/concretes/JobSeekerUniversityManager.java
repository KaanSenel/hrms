package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobSeekerUniversityService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.JobseekerUniversityDao;
import com.hrms.entities.concretes.JobseekerUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerUniversityManager implements JobSeekerUniversityService {

    private final JobseekerUniversityDao jobseekerUniversityDao;

    @Autowired
    public JobSeekerUniversityManager(JobseekerUniversityDao jobseekerUniversityDao) {
        this.jobseekerUniversityDao = jobseekerUniversityDao;
    }


    @Override
    public DataResult<List<JobseekerUniversity>> getByJobseekerCvId(int id) {
        Sort sort=Sort.by(Sort.Direction.DESC,"endYear");
        return new SuccessDataResult<>(this.jobseekerUniversityDao.findAll(sort));
    }

    @Override
    public DataResult<List<JobseekerUniversity>> getAll() {
        return new SuccessDataResult<>(this.jobseekerUniversityDao.findAll(),
                "Veriler getirildi.");
    }
}
