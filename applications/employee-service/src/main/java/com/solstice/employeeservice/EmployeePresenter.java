package com.solstice.employeeservice;

import org.springframework.stereotype.Component;

@Component
public class EmployeePresenter {

    public EmployeeInfo present(EmployeeRecord record) {
        return new EmployeeInfo(
                record.id,
                record.firstName,
                record.lastName,
                record.employeeNumber,
                record.office,
                record.title,
                record.email,
                record.imageURL
        );
    }
}
