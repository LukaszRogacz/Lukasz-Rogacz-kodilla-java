package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEmployeeFacade {

    public List<Company> findCompanyNameWith(CompanyDao companyDao,String arg){
        return companyDao.retrieveCompanyNameWith(arg);
    }
    
    public List<Employee> findEmployeeNameWith(EmployeeDao employeeDao, String arg){
        return employeeDao.retrieveEmployeeLastNameWith(arg);
    }

}
