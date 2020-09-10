package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeSearchTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeSearch employeeSearch;

    @Test
    public void findByKeyWordTest() throws SearchException {
        //Given
        String keyWord = "123";
        String keyWord2 = "233";
        Employee employee = new Employee("Jan", "Kowalski" + keyWord);
        Employee employee2 = new Employee("Jan", keyWord2 + "Kowalski");

        //when
        employeeDao.save(employee);
        employeeDao.save(employee2);
        EmployeeDto testedEmployee = employeeSearch.findEmployeeContainingKeyWord(keyWord);
        EmployeeDto testedEmployee2 = employeeSearch.findEmployeeContainingKeyWord(keyWord);

        //then
        Assert.notNull(testedEmployee);
        Assert.notNull(testedEmployee2);

        //cleanUp
        employeeDao.delete(employee);
        employeeDao.delete(employee2);
    }
}