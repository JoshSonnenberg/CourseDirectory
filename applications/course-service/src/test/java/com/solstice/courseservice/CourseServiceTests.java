package com.solstice.courseservice;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CourseServiceTests {

//    @Test
//    public void testGetAllCoursesWhenNoneExist() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        CourseRepository courseRepository = new CourseRepository(jdbcTemplate);
//        CourseController controller = new CourseController(courseRepository, new CoursePresenter());
//        List<CourseInfo> expectedCourses = null;
//        assertEquals(controller.courses(), expectedCourses);
//    }

//    @Test
//    public void testGetAllCoursesWhenOneExist() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        CourseRepository courseRepository = new CourseRepository(jdbcTemplate);
//        CourseController controller = new CourseController(courseRepository);
//        CourseInfo expectedCourse = new CourseInfo();
//        assertEquals(controller.courses().size(), 1);
//        assertEquals(controller.courses().get(0), expectedCourse);
//    }

}
