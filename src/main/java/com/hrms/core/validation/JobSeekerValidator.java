package com.hrms.core.validation;

import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.LastNameValidator;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.core.verification.EmailVerification;
import com.hrms.core.verification.IdentityNumberAvailableVerification;
import com.hrms.core.verification.MernisCheck;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerValidator {

    private JobSeekerDao jobSeekerDao;

    public JobSeekerValidator(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao=jobSeekerDao;
    }

    public Result jobSeekerCheck(JobSeeker jobSeeker) throws Exception {


        if(!FirstNameValidator.firstNameCheck(jobSeeker.getFirstName())){
            return new ErrorResult("İsim alanı boş bırakılamaz.");
        }
        if(!EmailValidator.emailCheck(jobSeeker.getEmail())){
            return new ErrorResult("E-mail alanı boş bırakılamaz.");
        }
        if(!IdentityNumberValidator.identityNumberCheck(jobSeeker.getIdentityNumber())){
            return new ErrorResult("Geçersiz Tc kimlik numarası girdiniz.");
        }
        if(!LastNameValidator.lastNameCheck(jobSeeker.getLastName())) {
            return new ErrorResult("Soyisim alanı boş bırakılamaz.");
        }
        if(!PasswordValidator.passwordCheck(jobSeeker.getPassword(), jobSeeker.getPasswordAgain())){
            return new ErrorResult("Parolalar birbiri ile uyuşmamaktadır.");
        }
        if(!YearOfBirthValidator.yearOfBirthCheck(jobSeeker.getYearOfBirth())){
            return new ErrorResult("Doğum yılı bilgisi boş bırakılamaz.");
        }
        if(!MernisCheck.mernisCheck(jobSeeker)){
            return new ErrorResult("Böyle bir kullanıcı devlet kayıtlarında bulunmamaktadır.");
        }
        if(this.jobSeekerDao.findByEmail(jobSeeker.getEmail())!=null){
            return new ErrorResult("Bu mail sistemde kayıtlıdır.");
        }

        if(this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber())!=null){
            return new ErrorResult("Bu TC kimlik no sistemde kayıtlıdır.");
        }
        /*
        if(!EmailVerification.linkVerification(jobSeeker.getEmail())){
            return new ErrorResult("Doğrulama yapılmadı.");
        }

         */
        return new SuccessResult("Doğrulama gerçekleşti, sisteme kayıt başarıyla yapıldı.");

    }
}
