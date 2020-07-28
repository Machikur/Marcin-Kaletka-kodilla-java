package com.kodilla.hibernate.bank.dao;

import com.kodilla.hibernate.bank.Account;
import com.kodilla.hibernate.bank.AccountService;
import com.kodilla.hibernate.bank.Client;
import com.kodilla.hibernate.bank.exeption.NoAccountExeption;
import com.kodilla.hibernate.bank.exeption.NoEnoughMoneyExeption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountDaoTestSuite {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void namedQueryGetAllMoneyTest() {
        //given
        Client client = new Client("Jan", "Kowalski", 55, new ArrayList<>());
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));
        Account account3 = new Account(BigDecimal.valueOf(2500));

        client.getAccountList().add(account1);
        client.getAccountList().add(account2);
        client.getAccountList().add(account3);

        account1.setClient(client);
        account2.setClient(client);
        account3.setClient(client);


        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);

        //when
        try {
            BigDecimal allMoneyOnAccount = accountDao.showAllMoneyOnAccount(client);

            //then
            Assert.assertEquals(BigDecimal.valueOf(4500).doubleValue(), allMoneyOnAccount.doubleValue(), 0.1);
        } catch (Exception s) {
        } finally {

            //cleanUp
            accountDao.deleteById(account1.getId());
        }
    }

    @Test
    public void namedQuerygetNumberOfAccountsTest() {
        //given
        Client client = new Client("Jan", "Kowalski", 55, new ArrayList<>());
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));
        Account account3 = new Account(BigDecimal.valueOf(2500));

        client.getAccountList().add(account1);
        client.getAccountList().add(account2);
        client.getAccountList().add(account3);

        account1.setClient(client);
        account2.setClient(client);
        account3.setClient(client);

        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);

        //when
        try {
            int numberOfAccounts = accountDao.getNumberOfAccounts(client);

            //then
            Assert.assertEquals(3, numberOfAccounts);
        } catch (Exception s) {

        } finally {

            //cleanUp
            accountDao.deleteById(account1.getId());
        }
    }

    @Test
    public void namedQueryGetAccountsOfPeopleOlderThanSixtyTest() {
        //given
        Client client1 = new Client("Jan", "Kowalski", 55, new ArrayList<>());
        Client client2 = new Client("Jan", "Kowalski", 65, new ArrayList<>());
        Client client3 = new Client("Jan", "Kowalski", 75, new ArrayList<>());

        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));
        Account account3 = new Account(BigDecimal.valueOf(2500));

        client1.getAccountList().add(account1);
        client2.getAccountList().add(account2);
        client3.getAccountList().add(account3);

        account1.setClient(client1);
        account2.setClient(client2);
        account3.setClient(client3);

        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);

        //when
        try {
            List<Account> accountList = accountDao.getAccountsOfPeopleOlderThanSixty(60);

            //then
            Assert.assertEquals(2, accountList.size());
        } catch (Exception s) {
        } finally {

            //cleanUp
            accountDao.deleteById(account1.getId());
            accountDao.deleteById(account2.getId());
            accountDao.deleteById(account3.getId());
        }
    }


}
