package com.solstice.employeeservice;

public class EmployeeInfo {

    public final String id;
    public final String firstName;
    public final String lastName;
    public final Integer employeeNumber;
    public final String office;
    public final String title;
    public final String email;
    public final String imageURL;

    public EmployeeInfo(String id, String firstName, String lastName, Integer employeeNumber, String office, String title, String email, String imageURL) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.office = office;
        this.title = title;
        this.email = email;
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }

        EmployeeInfo rhs = (EmployeeInfo) o;
        return this.id.equals(rhs.id) &&
                this.firstName.equals(rhs.firstName) &&
                this.lastName.equals(rhs.lastName) &&
                this.employeeNumber.equals(rhs.employeeNumber) &&
                this.office.equals(rhs.office) &&
                this.title.equals(rhs.title) &&
                this.email.equals(rhs.email) &&
                this.imageURL.equals(rhs.imageURL);
    }

    @Override
    public int hashCode() {
        return super.hashCode() +
                this.id.hashCode() +
                this.firstName.hashCode() +
                this.lastName.hashCode() +
                this.employeeNumber.hashCode() +
                this.office.hashCode() +
                this.title.hashCode() +
                this.email.hashCode() +
                this.imageURL.hashCode();
    }

}
