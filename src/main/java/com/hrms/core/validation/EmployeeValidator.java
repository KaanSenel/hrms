package com.hrms.core.validation;

import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.core.verification.EmailVerification;
import com.hrms.dataAccess.abstracts.EmployeeDao;
import com.hrms.entities.concretes.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidator {

    private EmployeeDao employeeDao;

    public EmployeeValidator(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Result validate(Employee employee){

        if(!CompanyNameValidator.companyNameCheck(employee.getCompanyName())){
            return new ErrorResult("İsim alanı boş bırakılamaz.");
        }
        if(!WebAddressValidator.webAddressCheck(employee.getWebAddress())){
            return new ErrorResult("Web sitesi alanı boş bırakılamaz.");
        }
        if(!EmailValidator.emailCheck(employee.getEmail())){
            return new ErrorResult("E-mail alanı boş bırakılamaz.");
        }
        if(!CompanyEmailValidator.companyEmailAvailableCheck(employee.getEmail(), employee.getWebAddress())){
            return new ErrorResult("Email ile web sitenizin domaini uyumsuzdur.");
        }
        if(!TelephoneValidator.telephoneCheck(employee.getPhoneNumber())){
            return new ErrorResult("Telefon alanı boş bırakılamaz.");
        }
        if(!PasswordValidator.passwordCheck(employee.getPassword(), employee.getPasswordAgain())){
            return new ErrorResult("Parolalar birbirleri ile uyuşmamaktadır.");
        }
        if(this.employeeDao.findByEmail(employee.getEmail())!=null){
            return new ErrorResult("Bu e-mail sistemde kayıtlıdır, işleminiz iptal edildi");
        }
        /*
        if(!EmailVerification.linkVerification(employee.getEmail())){
            return new ErrorResult("doğrulama yapılmadı");
        }

         */

        return new SuccessResult();
    }
}