package com.hrms.business.concretes;

import com.hrms.business.abstracts.ForeignLanguageService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.ForeignLanguageDao;
import com.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ForeignLanguageManager implements ForeignLanguageService {

    private final ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao){
        this.foreignLanguageDao=foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>(this.foreignLanguageDao.findAll(),
                "Veriler getirildi.");
    }

    @Override
    public DataResult<List<ForeignLanguage>> getByJobseekerCvId(int id) {
        return new SuccessDataResult<>(this.foreignLanguageDao.getByJobseekerCv_Id(id),
                "Veriler getirildi.");
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Yabancı dil bilgisi kaydedildi.");
    }
}
