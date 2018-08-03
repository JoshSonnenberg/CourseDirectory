package com.solstice.courseservice.course.utils;

import com.solstice.courseservice.course.model.CourseInfo;
import com.solstice.courseservice.course.util.CoursePresenter;
import com.solstice.courseservice.course.model.CourseRecord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoursePresenterTest {

    @Test
    public void testPresentCourse() {
        CourseInfo expectedInfo = new CourseInfo("lkjdfl", "MyCourse", "first, second");

        CourseRecord record = new CourseRecord("lkjdfl", "MyCourse", "first, second");
        CourseInfo info = CoursePresenter.present(record);

        assertEquals(info, expectedInfo);
    }

}
