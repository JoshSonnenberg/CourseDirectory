package com.solstice.employeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    public EmployeeController() {}

    @GetMapping("/")
    public String greeting() {
        return "Employee Service";
    }

}
