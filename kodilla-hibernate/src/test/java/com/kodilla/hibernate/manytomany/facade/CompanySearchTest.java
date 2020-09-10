package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanySearchTest {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private CompanySearch companySearch;

    @Test
    public void findByKeyWordTest() throws SearchException {
        //Given
        String keyWord = "123";
        String keyWord2 = "323";
        Company company = new Company("JAREKBUD" + keyWord);
        Company company2 = new Company( keyWord2 + "JAREKBUD" );

        //when
        companyDao.save(company);
        companyDao.save(company2);

        CompanyDto testedCompany = companySearch.findEmployeeContainingKeyWord(keyWord);
        CompanyDto testedCompany2 = companySearch.findEmployeeContainingKeyWord(keyWord2);

        //then
        Assert.notNull(testedCompany);
        Assert.notNull(testedCompany2);

        //cleanUp
        companyDao.delete(company);
        companyDao.delete(company2);
    }
}