package com.kodilla.hibernate.bank;

import com.kodilla.hibernate.bank.dao.AccountDao;
import com.kodilla.hibernate.bank.exeption.NoAccountExeption;
import com.kodilla.hibernate.bank.exeption.NoEnoughMoneyExeption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService {

    private AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public void transferMoney(@NotNull int numberIdFrom, @NotNull int numberIdTo, @DecimalMin(value = "0") BigDecimal amount) throws NoEnoughMoneyExeption, NoAccountExeption {
        Optional<Account> accountFrom = accountDao.findById(numberIdFrom);
        Optional<Account> accountTo = accountDao.findById(numberIdTo);
        if (accountFrom.isPresent() && accountTo.isPresent()) {
            Account from = accountFrom.get();
            Account to = accountTo.get();
            if (from.getCashBalance().compareTo(amount) > -1) {
                from.setCashBalance(from.getCashBalance().subtract(amount));
                to.setCashBalance(to.getCashBalance().add(amount));
                accountDao.save(from);
                accountDao.save(to);
            } else {
                throw new NoEnoughMoneyExeption("Niewystarczająca ilość funduszy");
            }
        } else {
            throw new NoAccountExeption("Nie znaleziono konta");
        }
    }
}
