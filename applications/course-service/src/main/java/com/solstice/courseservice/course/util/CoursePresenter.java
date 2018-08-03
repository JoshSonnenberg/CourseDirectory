package com.solstice.courseservice.course.util;

import com.solstice.courseservice.course.model.CourseInfo;
import com.solstice.courseservice.course.model.CourseRecord;
import org.springframework.stereotype.Component;

@Component
public class CoursePresenter {

    public static CourseInfo present(CourseRecord record) {
        return new CourseInfo(
                record.getId(),
                record.getName(),
                record.getTags()
        );
    }

}
