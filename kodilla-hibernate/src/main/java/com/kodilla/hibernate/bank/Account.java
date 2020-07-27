package com.kodilla.hibernate.bank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name = "Account.showAllMoneyOnAccount",
                query = "SELECT SUM(a.cashBalance) FROM Account a " +
                        "WHERE a.client=:CLIENT"),

        @NamedQuery(name = "Account.getNumberOfAccounts",
                query = " SELECT COUNT(a.id) FROM Account a " +
                        "WHERE a.client =:CLIENT "),

        @NamedQuery(name = "Account.getAccountsOfPeopleOlderThanSixty",
                query = "FROM Account a " +
                        "WHERE a.client.age>60 ")
})

@Entity
@Table(name = "ACCOUNT")
public class Account {
    private int id;
    private Client client;
    private BigDecimal cashBalance;

    public Account(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Account() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "CLIENT")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Column(name = "CASH_BALANCE")
    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }
}
