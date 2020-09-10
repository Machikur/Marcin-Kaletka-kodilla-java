package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeSearch {

    @Autowired
    private EmployeeDao employeeDao;

    private Logger LOGGER= LoggerFactory.getLogger(EmployeeSearch.class);

    public EmployeeDto findEmployeeContainingKeyWord(String keyWord) throws SearchException {
        Optional<Employee> optionalEmployee = employeeDao.showEmployeeContainingWord(keyWord);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            LOGGER.info("The employee was found: " + employee.getFirstname() + " " + employee.getLastname());
            return new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname());
        } else {
            LOGGER.error("Employee dosn't exist");
            throw new SearchException("Searching error");
        }
    }


}
