package com.hrms.business.concretes;

import com.hrms.business.abstracts.WorkExperienceService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.WorkExperienceDao;
import com.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkExperienceManager implements WorkExperienceService {

    @Autowired
    private final WorkExperienceDao workExperienceDao;

    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }


    @Override
    public DataResult<List<WorkExperience>> getByJobseekerCvIdOrderByEndYearDesc(int id) {
        return new SuccessDataResult<>(this.workExperienceDao.getByJobseekerCv_IdOrderByEndYearDesc(id),
                "Veriler getirildi.");
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<>
                (this.workExperienceDao.findAll(),"Veriler getirildi.");
    }

    @Override
    public Result add(WorkExperience workExperience) {
        if(workExperience.getEndYear()==null){
            workExperience.setEndYear("Devam Ediyor.");
        }
        this.workExperienceDao.save(workExperience);
        return new SuccessResult("Kaydedildi.");
    }

    @Override
    public DataResult<List<WorkExperience>> getByJobseekerCvId(int id) {
        return new SuccessDataResult<>
                (this.workExperienceDao.getByJobseekerCvId(id),
                        "Veriler getirildi.");
    }
}
