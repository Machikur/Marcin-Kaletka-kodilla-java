package com.kodilla.hibernate.manytomany.facade.search;

import com.kodilla.hibernate.manytomany.facade.pojo.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.pojo.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EmployeeSearch {

    @Autowired
    private EmployeeDao employeeDao;


    public List<EmployeeDto> findEmployeeContainingKeyWord(String keyWord) {
        List<Employee> optionalEmployees = employeeDao.showEmployeeContainingWord(keyWord);
        return optionalEmployees.stream()
                .map(employee -> new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname()))
                .collect(Collectors.toList());
    }


}
