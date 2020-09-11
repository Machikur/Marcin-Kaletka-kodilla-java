package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeSearch {

    @Autowired
    private EmployeeDao employeeDao;


    public List<EmployeeDto> findEmployeeContainingKeyWord(String keyWord) {
        List<Employee> optionalEmployee = employeeDao.showEmployeeContainingWord(keyWord);

        if (!optionalEmployee.isEmpty()) {
            List<EmployeeDto> employeeDtos = new ArrayList<>();
            for (int i = 0; i < optionalEmployee.size(); i++) {
                employeeDtos.add(new EmployeeDto(optionalEmployee.get(i).getId(), optionalEmployee.get(i).getLastname(),
                        optionalEmployee.get(i).getLastname()));
            }
            return employeeDtos;
        } else {
            return new ArrayList<>();
        }
    }


}
