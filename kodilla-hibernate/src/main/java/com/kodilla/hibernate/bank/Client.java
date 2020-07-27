package com.kodilla.hibernate.bank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "CLIENT")
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private List<Account> accountList;

    public Client() {
    }

    public Client(String firstName, String lastName, int age, List<Account> accountList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.accountList = accountList;
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

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(targetEntity = Account.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
