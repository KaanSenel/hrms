package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobseekerCv;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JobSeekerCvService {

    DataResult<List<JobseekerCv>> getAll();

    Result add(JobseekerCv jobseekerCv);

    Result addWithPicture(JobseekerCv jobseekerCv,MultipartFile file) throws IOException;
    JobseekerCv getById(int id);

}
