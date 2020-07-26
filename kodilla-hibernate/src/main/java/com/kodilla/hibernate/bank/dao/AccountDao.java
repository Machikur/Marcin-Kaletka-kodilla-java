package com.kodilla.hibernate.bank.dao;

import com.kodilla.hibernate.bank.Account;
import com.kodilla.hibernate.bank.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountDao extends CrudRepository<Account,Integer> {

    @Query
    long showAllMoneyOnAccount(@Param("CLIENT") Client client);

    @Query
    long showAmountOfAccounts(@Param("CLIENT") Client client);
}
