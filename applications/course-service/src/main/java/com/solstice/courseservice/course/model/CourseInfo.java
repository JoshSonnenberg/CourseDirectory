package com.solstice.courseservice.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseInfo {

    public String id;
    public String name;
    public String tags;

}
