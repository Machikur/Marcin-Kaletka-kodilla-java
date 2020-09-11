package com.kodilla.hibernate.manytomany.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFacade {

    @Autowired
    private CompanySearch companySearch;

    @Autowired
    private EmployeeSearch employeeSearch;

    private Logger LOGGER = LoggerFactory.getLogger(EmployeeSearch.class);

    public List<CompanyDto> findCompany(String keyWord) throws SearchException {

        List<CompanyDto> companies = companySearch.findEmployeeContainingKeyWord(keyWord);
        if (!companies.isEmpty()) {
            for (CompanyDto companyDto : companies) {
                LOGGER.info("The company was found: " + companyDto.getName());
                return companySearch.findEmployeeContainingKeyWord(keyWord);
            }
        } else {
            LOGGER.error("Searching error");
            throw new SearchException("Company dosn't exist");
        }
        return new ArrayList<>();
    }

    public List<EmployeeDto> findEmployee(String keyWord) throws SearchException {
        List<EmployeeDto> employees = employeeSearch.findEmployeeContainingKeyWord(keyWord);
        if (!employees.isEmpty()) {
            for (EmployeeDto employee : employees) {
                LOGGER.info("The employee was found: " + employee.getFirstname() + " " + employee.getLastname());
                return employees;
            }
        } else {
            LOGGER.error("Searching error");
            throw new SearchException("Employee dosn't exist");
        }
        return new ArrayList<>();
    }
}
