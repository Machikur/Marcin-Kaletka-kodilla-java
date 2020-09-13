package com.kodilla.hibernate.bank;

import com.kodilla.hibernate.bank.dao.AccountDao;
import com.kodilla.hibernate.bank.exeption.NoAccountExeption;
import com.kodilla.hibernate.bank.exeption.NoEnoughMoneyExeption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTestSuite {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void transferMoneyTest() throws NoEnoughMoneyExeption, NoAccountExeption {
        //given
        Account account1 = new Account(BigDecimal.valueOf(500));
        Account account2 = new Account(BigDecimal.valueOf(1500));

        AccountService accountService = new AccountService(accountDao);

        //when
        accountDao.save(account1);
        accountDao.save(account2);


        try {
            //when
            BigDecimal cashFromBefore = accountDao.findById(account1.getId()).get().getCashBalance();
            BigDecimal cashToBefore = accountDao.findById(account2.getId()).get().getCashBalance();
            accountService.transferMoney(account1.getId(), account2.getId(), BigDecimal.valueOf(100));
            BigDecimal cashFromAfter = accountDao.findById(account1.getId()).get().getCashBalance();
            BigDecimal cashToAfter = accountDao.findById(account2.getId()).get().getCashBalance();

            //then
            Assert.assertEquals(100, cashFromBefore.subtract(cashFromAfter).doubleValue(), 0.1);
            Assert.assertEquals(100, cashToAfter.subtract(cashToBefore).doubleValue(), 0.1);
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


        accountDao.save(account1);
        accountDao.save(account2);

        //when && then
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
