package com.hrms.core.verification;

import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityNumberAvailableVerification {

    private JobSeekerDao jobSeekerDao;

    public IdentityNumberAvailableVerification(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    public boolean identityAvailableCheck(String identityNo) {
        List<String> identities= this.jobSeekerDao.findAll().stream().map(JobSeeker::getIdentityNumber).toList();
        for(String id : identities){
            if(id.equals(identityNo)){
                return false;
            }
        }
        return true;
    }
}
