package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeFacadeTestSuite {

    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    CompanyEmployeeFacade companyEmployeeFacade;

    @Test
    public void testCompanyNameWith(){
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        int companyWith=companyEmployeeFacade.findCompanyNameWith("Ma").size();

        //Then
        Assert.assertEquals(3, companyWith);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testEmployeeLastNameWith(){
        //Given
        Employee johnsmith=new Employee("john","smith");
        Employee jessiepinkman=new Employee("jessie","pinkman");
        Employee walterwhite=new Employee("walter","white");

        //When
        employeeDao.save(johnsmith);
        int johnsmithId = johnsmith.getId();
        employeeDao.save(jessiepinkman);
        int jessiepinkmanId = jessiepinkman.getId();
        employeeDao.save(walterwhite);
        int walterwhiteId = walterwhite.getId();

        int employeeWith=companyEmployeeFacade.findEmployeeNameWith("it").size();

        //Then
        Assert.assertEquals(2, employeeWith);

        //CleanUp
        try {
            employeeDao.deleteById(johnsmithId);
            employeeDao.deleteById(jessiepinkmanId);
            employeeDao.deleteById(walterwhiteId);
        } catch (Exception e) {
            //do nothing
        }
    }



}
