package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {

    DataResult<List<ForeignLanguage>> getAll();

    DataResult<List<ForeignLanguage>> getByJobseekerCvId(int id);

    Result add(ForeignLanguage foreignLanguage);
}
