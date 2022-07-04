package com.hrms.validation.concretes;

import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.mernis.ADAKPSPublicSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerValidationManager {

    private JobSeekerDao jobSeekerService;


    @Autowired
    public JobSeekerValidationManager(JobSeekerDao jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }


    public Result check(JobSeeker jobSeeker) throws Exception{
        if(!emailCheck(jobSeeker.getEmail())){
            return new ErrorResult("Bu mail sistemde kayıtlıdır.");
        }
        if(!mernisCheck(jobSeeker)){
            return new ErrorResult("Böyle bir kullanıcı devlet kayıtlarında bulunmamaktadır.");
        }
        if(!identityCheck(jobSeeker.getIdentityNo())){
            return new ErrorResult("Bu TC kimlik no sistemde kayıtlıdır.");
        }
        return new SuccessResult("Doğrulama gerçekleşti, sisteme kayıt başarıyla yapıldı.");
    }


    public boolean emailCheck(String email) {
        List<String> emails= this.jobSeekerService.findAll().stream().map(JobSeeker::getEmail).toList();
        for (String e : emails){
            if(e.equals(email)){
                return false;
            }
        }
        return true;
    }


    public boolean mernisCheck(JobSeeker jobSeeker) throws Exception {
        ADAKPSPublicSoap client=new ADAKPSPublicSoap();
        return client.TCKimlikNoDogrula(Long.getLong(jobSeeker.getIdentityNo()),
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getYearOfBirth());
    }


    public boolean identityCheck(String identityNo) {
        List<String> identities= this.jobSeekerService.findAll().stream().map(JobSeeker::getIdentityNo).toList();
        for(String id : identities){
            if(id.equals(identityNo)){
                return false;
            }
        }
        return true;
    }
}