package com.kodilla.hibernate.manytomany.facade;


public class EmployeeDto {
    private final int id;
    private final String firstname;
    private final String lastname;

    public EmployeeDto(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
