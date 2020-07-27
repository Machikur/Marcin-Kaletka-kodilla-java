package com.kodilla.hibernate.bank.dao;

import com.kodilla.hibernate.bank.Account;
import com.kodilla.hibernate.bank.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface AccountDao extends CrudRepository<Account, Integer> {


    @Query
    BigDecimal showAllMoneyOnAccount(@Param("CLIENT") Client client);

    @Query
    int getNumberOfAccounts(@Param("CLIENT") Client client);

    @Query
    List<Account> getAccountsOfPeopleOlderThanSixty();
}
