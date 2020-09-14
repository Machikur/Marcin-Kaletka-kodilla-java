package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String peselID;
    private final String name;
    private final String lastName;
    private final BigDecimal salary;

    public Employee(String peselID, String name, String lastName, BigDecimal salary) {
        this.peselID = peselID;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getPeselID() {
        return peselID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(peselID, employee.peselID) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peselID, name, lastName, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselID='" + peselID + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
