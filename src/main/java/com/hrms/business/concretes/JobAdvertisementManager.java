package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.validation.JobAdvertisementValidator;
import com.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.entities.concretes.JobAdvertisement;
import com.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final JobAdvertisementValidator jobAdvertisementValidator;

    @Autowired
    public JobAdvertisementManager (JobAdvertisementDao jobAdvertisementDao,JobAdvertisementValidator jobAdvertisementValidator){
        this.jobAdvertisementDao=jobAdvertisementDao;
        this.jobAdvertisementValidator=jobAdvertisementValidator;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll());
    }

    //aktif iş ilanlarını getirir.
    @Override
    public DataResult<List<JobAdvertisementDto>> getAllActive() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByIsActive());
    }

    @Override
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {

        Result result=this.jobAdvertisementValidator.jobAdvertisementCheck(jobAdvertisement);
        if(result.isSuccess()){
            this.jobAdvertisementDao.save(jobAdvertisement);
        }
        return result;
    }

    @Override
    public List<JobAdvertisementDto> findByIsActiveOrderByListingDateAsc(boolean active) {
        return this.jobAdvertisementDao.findByIsActiveOrderByListingDateAsc(true);
    }

    @Override
    public List<JobAdvertisementDto> getByEmployee_CompanyNameAndIsActive(String companyName, boolean active) {
        return this.jobAdvertisementDao.getByEmployee_CompanyNameAndIsActive(companyName, true);
    }
}
