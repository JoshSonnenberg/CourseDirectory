package com.solstice.courseservice.enrollment.model;

public class EnrollmentInfo {

    public final String employeeId;
    public final String courseId;
    public final boolean completed;

    public EnrollmentInfo(String employeeId, String courseId, boolean completed) {
        this.employeeId = employeeId;
        this.courseId = courseId;
        this.completed = completed;
    }

}
