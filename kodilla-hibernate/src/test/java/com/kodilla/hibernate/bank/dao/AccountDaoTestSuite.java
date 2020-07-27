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

        //when
        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);

        //then
        try {
            BigDecimal allMoneyOnAccount = accountDao.showAllMoneyOnAccount(client);

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

        //when
        accountDao.save(account1);
        accountDao.save(account2);
        accountDao.save(account3);

        //then
        try {
            List<Account> accountList = accountDao.getAccountsOfPeopleOlderThanSixty();

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

    @Test
    public void transferMoneyTest() throws NoEnoughMoneyExeption, NoAccountExeption {
        //given
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));

        AccountService accountService = new AccountService(accountDao);

        //when
        accountDao.save(account1);
        accountDao.save(account2);

        //then
        try {
            BigDecimal cashFromBefore = accountDao.findById(account1.getId()).get().getCashBalance();
            BigDecimal cashToBefore = accountDao.findById(account2.getId()).get().getCashBalance();
            accountService.transferMoney(account1.getId(), account2.getId(), BigDecimal.valueOf(100));
            BigDecimal cashFromAfter = accountDao.findById(account1.getId()).get().getCashBalance();
            BigDecimal cashToAfter = accountDao.findById(account2.getId()).get().getCashBalance();

            Assert.assertEquals(100, cashFromBefore.subtract(cashFromAfter).doubleValue(), 0.1);
            Assert.assertEquals(100, cashToAfter.subtract(cashToBefore).doubleValue(), 0.1);
        } catch (Exception s) {
        } finally {
            //cleanUp
            accountDao.deleteById(account1.getId());
            accountDao.deleteById(account2.getId());
        }

    }

    @Test(expected = NoEnoughMoneyExeption.class)
    public void transferMoneyTestNoEnoughMoneyTest() throws NoEnoughMoneyExeption, NoAccountExeption {
        //given
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));

        AccountService accountService = new AccountService(accountDao);

        //when
        accountDao.save(account1);
        accountDao.save(account2);

        //then
        try {
            accountService.transferMoney(account1.getId(), account2.getId(), BigDecimal.valueOf(1000));
        } finally {
            //cleanUp
            accountDao.deleteById(account1.getId());
            accountDao.deleteById(account2.getId());
        }
    }

    @Test(expected = NoAccountExeption.class)
    public void transferMoneyTestNoAccountExeptionTest() throws NoEnoughMoneyExeption, NoAccountExeption {
        //given
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));
        int nonExistingId = 0;

        AccountService accountService = new AccountService(accountDao);

        //when
        accountDao.save(account1);
        accountDao.save(account2);

        //then
        try {
            accountService.transferMoney(account1.getId(), nonExistingId, BigDecimal.valueOf(1000));
        } finally {
            //cleanUp
            accountDao.deleteById(account1.getId());
            accountDao.deleteById(account2.getId());
        }
    }
}
