package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchFacadeTest {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;


    @Test
    public void findEmployeeByKeyWordTest() throws SearchException {
        //Given
        String keyWord = "123";
        String keyWord2 = "233";
        Employee employee = new Employee("Jan", "Kowalski" + keyWord);
        Employee employee2 = new Employee("Jan", keyWord2 + "Kowalski");

        //when
        employeeDao.save(employee);
        employeeDao.save(employee2);
        List<EmployeeDto> testedEmployee = searchFacade.findEmployee(keyWord);
        List<EmployeeDto> testedEmployee2 = searchFacade.findEmployee(keyWord2);

        //then
        Assert.notEmpty(testedEmployee);
        Assert.notEmpty(testedEmployee2);

        //cleanUp
        employeeDao.delete(employee);
        employeeDao.delete(employee2);
    }

    @Test
    public void findCompanyByKeyWordTest() throws SearchException {
        //Given
        String keyWord = "123";
        String keyWord2 = "323";
        Company company = new Company("JAREKBUD" + keyWord);
        Company company2 = new Company(keyWord2 + "JAREKBUD");

        //when
        companyDao.save(company);
        companyDao.save(company2);

        List<CompanyDto> testedCompany = searchFacade.findCompany(keyWord);
        List<CompanyDto> testedCompany2 = searchFacade.findCompany(keyWord2);

        //then
        Assert.notEmpty(testedCompany);
        Assert.notEmpty(testedCompany2);

        //cleanUp
        companyDao.delete(company);
        companyDao.delete(company2);
    }

    @Test(expected = SearchException.class)
    public void nonExistingEmployee() throws SearchException {
        //given
        String nonExistingKey = "xxx";

        //when
        searchFacade.findCompany(nonExistingKey);

        //then
        //nothing

    }

    @Test(expected = SearchException.class)
    public void nonExistingCompany() throws SearchException {
        //given
        String nonExistingKey = "xxx";

        //when
        searchFacade.findCompany(nonExistingKey);

        //then
        //nothing

    }
}