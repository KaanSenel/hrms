package com.hrms.business.concretes;

import com.hrms.business.abstracts.EmployeeService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.validation.EmployeeValidator;
import com.hrms.dataAccess.abstracts.EmployeeDao;
import com.hrms.entities.concretes.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmployeeValidator employeeValidator;

    public EmployeeManager(EmployeeDao employeeDao,EmployeeValidator employeeValidator) {
        this.employeeDao = employeeDao;
        this.employeeValidator=employeeValidator;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(employeeDao.findAll());
    }

    @Override
    public Result add(@RequestBody Employee employee) {
        Result result=employeeValidator.validate(employee);
        if(result.isSuccess()){
            this.employeeDao.save(employee);
        }
        return result;
    }

}
