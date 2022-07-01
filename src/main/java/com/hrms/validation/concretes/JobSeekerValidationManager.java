package com.hrms.validation.concretes;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.validation.abstracts.JobSeekerValidationService;

import java.util.List;

public class JobSeekerValidationManager implements JobSeekerValidationService {

    private JobSeekerService jobSeekerService;

    public JobSeekerValidationManager(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result check(JobSeeker jobSeeker) {
        if(emailCheck(jobSeeker.getEmail()) &&
               mernisCheck(String.valueOf(jobSeeker.getIdentityNo())) &&
               identityCheck(jobSeeker.getIdentityNo())){

        }
    }

    @Override
    public Result emailCheck(String email) {
        List<String> emails=this.jobSeekerService.getAll().stream().map(JobSeeker::getEmail).toList();
        for (String e : emails){
            if(e.equals(email)){
                return new ErrorResult("Bu mail sistemde kayıtlı.");
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result mernisCheck(String identityNo) {
        //mernisi bagla
        return null;
    }

    @Override
    public Result identityCheck(long identityNo) {
        List<Long> identities= this.jobSeekerService.getAll().stream().map(JobSeeker::getIdentityNo).toList();
        for(long id : identities){
            if(id==identityNo){
                return new ErrorResult("Bu Tc kimlik numarası sistemde kayıtlı.");
            }
        }
        return new SuccessResult();
    }

}