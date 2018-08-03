package com.solstice.courseservice.enrollment.service;

import com.solstice.courseservice.enrollment.database.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository repository) {
        this.enrollmentRepository = repository;
    }

    public List<String> employeeIdsByCourseIds(List<String> courseIds) {
        List<String> employeeIds = enrollmentRepository.getEmployeeIdsByCourseIds(courseIds);
        if (employeeIds.size() == 0)
            return employeeIds;

        return employeeIds;
    }
}
