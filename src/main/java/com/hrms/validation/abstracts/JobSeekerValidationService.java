package com.hrms.validation.abstracts;

import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

public interface JobSeekerValidationService {

    Result check(JobSeeker jobSeeker);
    Result emailCheck(String email);
    Result mernisCheck(String identityNo);
    Result identityCheck(long identityNo);
}
