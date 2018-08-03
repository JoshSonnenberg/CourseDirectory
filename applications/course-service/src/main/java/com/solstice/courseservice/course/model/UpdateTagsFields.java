package com.solstice.courseservice.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTagsFields {

    public String courseId;
    public String tags;

}
