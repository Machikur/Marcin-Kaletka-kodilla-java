package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanySearch {
    @Autowired
    private CompanyDao companyDao;

    private Logger LOGGER= LoggerFactory.getLogger(CompanySearch.class);

    public CompanyDto findEmployeeContainingKeyWord(String keyWord) throws SearchException{
        Optional<Company> optionalCompany=companyDao.showCompaniesContainingWord(keyWord);
        if (optionalCompany.isPresent()){
            Company company= optionalCompany.get();
            LOGGER.info("The company was found: " + company.getName());
            return new CompanyDto(company.getId(),company.getName());
        }
        else {
            LOGGER.error("Company dosn't exist");
            throw new SearchException("Company dosn't exist");
        }
    }
}
