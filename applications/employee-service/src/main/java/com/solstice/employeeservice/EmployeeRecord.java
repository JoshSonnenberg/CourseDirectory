package com.solstice.employeeservice;

public class EmployeeRecord {

    public final String id;
    public final String firstName;
    public final String lastName;
    public final Integer employeeNumber;
    public final String office;
    public final String title;
    public final String email;
    public final String imageURL;

    public EmployeeRecord(String id, String firstName, String lastName, Integer employeeNumber, String office, String title, String email, String imageURL) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.office = office;
        this.title = title;
        this.email = email;
        this.imageURL = imageURL;
    }
}
