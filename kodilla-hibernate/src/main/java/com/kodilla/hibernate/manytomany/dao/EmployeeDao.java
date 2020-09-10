package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> showEmployeeWithLastName(@Param("LASTNAME") String lastname);

    @Query
    Optional<Employee> showEmployeeContainingWord(@Param("keyWord") String keyWord);
}
