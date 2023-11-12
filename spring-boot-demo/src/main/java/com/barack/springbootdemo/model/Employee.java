package com.barack.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String department;
}
