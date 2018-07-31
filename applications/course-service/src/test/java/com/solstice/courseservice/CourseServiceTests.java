package com.solstice.courseservice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CourseServiceTests {

    @Test
    public void testGetAllCoursesWhenNoneExist() {
        CourseController controller = new CourseController();
        List<CourseInfo> expectedCourses = null;
        assertEquals(controller.courses(), expectedCourses);
    }

    @Test
    public void testGetAllCoursesWhenOneExist() {
        CourseController controller = new CourseController();
        CourseInfo expectedCourse = new CourseInfo();
        assertEquals(controller.courses().size(), 1);
        assertEquals(controller.courses().get(0), expectedCourse);
    }

}
