package com.solstice.courseservice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoursePresenterTest {

    @Test
    public void testPresentCourse() {
        CourseInfo expectedInfo = new CourseInfo("lkjdfl", "MyCourse", "first, second");

        CourseRecord record = new CourseRecord("lkjdfl", "MyCourse", "first, second");
        CoursePresenter presenter = new CoursePresenter();
        CourseInfo info = presenter.present(record);

        assertEquals(info, expectedInfo);
    }

}
