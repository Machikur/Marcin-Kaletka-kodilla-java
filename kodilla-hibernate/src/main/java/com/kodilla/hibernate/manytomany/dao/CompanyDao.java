package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.facade.pojo.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> showCompaniesWithFirstThreeCharacters(@Param("NAME") String name);

    @Query
    List<Company> showCompaniesContainingWord(@Param("KEYWORD") String keyWord);

}