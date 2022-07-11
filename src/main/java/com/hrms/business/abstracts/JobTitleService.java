package com.hrms.business.abstracts;

import com.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {

    public List<JobTitle> getAll();

}
