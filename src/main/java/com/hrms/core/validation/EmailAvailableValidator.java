package com.hrms.core.validation;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailAvailableValidator {

    private JobSeekerDao jobSeekerDao;

    public EmailAvailableValidator(JobSeekerDao jobSeekerDao){
        this.jobSeekerDao=jobSeekerDao;
    }

    public boolean emailAvailableCheck(String email) {
        List<String> emails= this.jobSeekerDao.findAll().stream().map(JobSeeker::getEmail).toList();
        for (String e : emails){
            if(e.equals(email)){
                return false;
            }
        }
        return true;
    }
}
