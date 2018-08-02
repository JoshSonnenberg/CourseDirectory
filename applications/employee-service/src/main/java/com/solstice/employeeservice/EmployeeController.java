package com.solstice.employeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeePresenter employeePresenter;

    public EmployeeController() {}

    @GetMapping
    public String greeting() {
        return "Employee Service";
    }

    @GetMapping("/course/{courseId}")
    public List<EmployeeInfo> employeesByCourseId(@PathVariable("courseId") String courseId) {
        return EmployeeRepository.getEmployeesByCourseId(courseId)
                .stream()
                .map(employeePresenter::present)
                .collect(toList());
    }

}
