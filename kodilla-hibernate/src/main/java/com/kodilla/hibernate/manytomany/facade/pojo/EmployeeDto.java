package com.kodilla.hibernate.manytomany.facade.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmployeeDto {
    private final int id;
    private final String firstname;
    private final String lastname;

}
