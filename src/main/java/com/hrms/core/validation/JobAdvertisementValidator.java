package com.hrms.core.validation;

import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.entities.concretes.JobAdvertisement;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertisementValidator {


    public Result jobAdvertisementCheck(JobAdvertisement jobAdvertisement){
        if (!JobTitleChooseValidator.jobTitleCheck(jobAdvertisement.getJobTitle().getId())){
            return new ErrorResult("İş pozisyonu bilgisi boş bırakılamaz");
        }
        if(!DescriptionValidator.descriptionCheck(jobAdvertisement.getDescription())){
            return new ErrorResult("İş tanımı bilgisi boş bırakılamaz.");
        }
        if(!CityChooseValidator.cityCheck(jobAdvertisement.getCity().getId())){
            return new ErrorResult("Şehir bilgisi boş bırakılamaz.");
        }
        if(!OpenPositionValidator.openPositionCheck(jobAdvertisement.getOpenPositions())){
            return new ErrorResult("Açık pozisyon sayısı boş bırakılamaz.");
        }
        if(!AppDeadlineValidator.appDeadlineCheck(jobAdvertisement.getAppDeadline())){
            return new ErrorResult("Son başvuru tarihi bilgisi boş bırakılamaz.");
        }
        return new SuccessResult("İş ilanı bilgisi başarıyla girildi.");
    }
}
