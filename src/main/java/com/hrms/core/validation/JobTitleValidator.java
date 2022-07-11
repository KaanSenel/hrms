package com.hrms.core.validation;

import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.entities.concretes.JobTitle;

public class JobTitleValidator {

    private JobTitleDao jobTitleDao;

    public JobTitleValidator(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    public Result jobTitleCheck(JobTitle jobTitle){
        if(!TitleValidator.titleCheck(jobTitle.getTitle())){
            return new ErrorResult("Ünvan alanı boş bırakılamaz.");
        }
        if(this.jobTitleDao.findByTitle(jobTitle.getTitle())!=null){
            return new ErrorResult("Bu ünvan listede mevcuttur");
        }
        return new SuccessResult();
    }
}
