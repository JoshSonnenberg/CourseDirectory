package com.solstice.courseservice;

import org.springframework.stereotype.Component;

@Component
public class CoursePresenter {

    public CourseInfo present(CourseRecord record) {
        return new CourseInfo(
                record.id,
                record.name,
                record.tags
        );
    }

}
