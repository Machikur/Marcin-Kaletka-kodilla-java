package com.kodilla.hibernate.manytomany.facade.search;

import com.kodilla.hibernate.manytomany.facade.pojo.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.pojo.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    @Autowired
    private CompanySearch companySearch;

    @Autowired
    private EmployeeSearch employeeSearch;

    private Logger LOGGER = LoggerFactory.getLogger(EmployeeSearch.class);

    public List<CompanyDto> findCompany(String keyWord) throws SearchException {

        List<CompanyDto> companies = companySearch.findComapnyContainingKeyWord(keyWord);
        if (!companies.isEmpty()) {
            for (CompanyDto companyDto : companies) {
                LOGGER.info("The company was found: " + companyDto.getName());
            }
            return companies;
        } else {
            LOGGER.error("Searching error");
            throw new SearchException("Company dosn't exist");
        }
    }

    public List<EmployeeDto> findEmployee(String keyWord) throws SearchException {
        List<EmployeeDto> employees = employeeSearch.findEmployeeContainingKeyWord(keyWord);
        if (!employees.isEmpty()) {
            for (EmployeeDto employee : employees) {
                LOGGER.info("The employee was found: " + employee.getFirstname() + " " + employee.getLastname());
            }
            return employees;

        } else {
            LOGGER.error("Searching error");
            throw new SearchException("Employee dosn't exist");
        }
    }
}
