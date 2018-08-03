package com.solstice.courseservice.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRecord {

    private String id;
    private String name;
    private String tags;

}
