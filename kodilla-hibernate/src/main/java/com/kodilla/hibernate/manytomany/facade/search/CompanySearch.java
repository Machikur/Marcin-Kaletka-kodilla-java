package com.kodilla.hibernate.manytomany.facade.search;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.facade.pojo.Company;
import com.kodilla.hibernate.manytomany.facade.pojo.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanySearch {

    @Autowired
    private CompanyDao companyDao;


    public List<CompanyDto> findComapnyContainingKeyWord(String keyWord) throws SearchException {
        List<Company> optionalCompanies = companyDao.showCompaniesContainingWord(keyWord);

        return optionalCompanies.stream()
                .map(company -> new CompanyDto(company.getId(), company.getName()))
                .collect(Collectors.toList());

    }
}
