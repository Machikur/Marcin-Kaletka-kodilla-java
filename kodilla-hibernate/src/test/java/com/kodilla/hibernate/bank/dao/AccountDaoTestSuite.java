package com.kodilla.hibernate.bank.dao;

import com.kodilla.hibernate.bank.Account;
import com.kodilla.hibernate.bank.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountDaoTestSuite {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void namedQueryGetAllMoneyTest() {
        //given
        Client client = new Client("Jan", "Kowalski", new ArrayList<>());
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));
        Account account3 = new Account(BigDecimal.valueOf(2500));

        client.getAccountList().add(account1);
        client.getAccountList().add(account2);
        client.getAccountList().add(account3);

        account1.setClient(client);
        account2.setClient(client);
        account3.setClient(client);

        //when
        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);
        try {
            BigDecimal allMoneyOnAccount = accountDao.showAllMoneyOnAccount(client);


            //then
            Assert.assertEquals(BigDecimal.valueOf(4500).doubleValue(), allMoneyOnAccount.doubleValue(),0.1);
        } catch (Exception s) {
        } finally {

            //cleanUp
            accountDao.deleteById(account1.getId());

        }
    }

    @Test
    public void namedQuerygetNumberOfAccountsTest() {
        //given
        Client client = new Client("Jan", "Kowalski", new ArrayList<>());
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));
        Account account3 = new Account(BigDecimal.valueOf(2500));

        client.getAccountList().add(account1);
        client.getAccountList().add(account2);
        client.getAccountList().add(account3);

        account1.setClient(client);
        account2.setClient(client);
        account3.setClient(client);

        //when
        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);

        //then

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
}
