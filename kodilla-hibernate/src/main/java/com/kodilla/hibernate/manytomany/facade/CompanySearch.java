package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanySearch {

    @Autowired
    private CompanyDao companyDao;


    public List<CompanyDto> findEmployeeContainingKeyWord(String keyWord) throws SearchException {
        List<Company> optionalCompany = companyDao.showCompaniesContainingWord(keyWord);

        if (!optionalCompany.isEmpty()) {
            List<CompanyDto> companyDtos = new ArrayList<>();
            for (int i = 0; i < optionalCompany.size(); i++) {
                companyDtos.add(new CompanyDto(optionalCompany.get(i).getId(), optionalCompany.get(i).getName()));
            }
            return companyDtos;
        } else {
            return new ArrayList<>();
        }
    }
}
