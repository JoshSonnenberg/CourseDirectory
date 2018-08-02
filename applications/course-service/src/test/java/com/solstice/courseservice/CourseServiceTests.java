package com.solstice.courseservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseServiceTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGreeting() throws Exception {
        this.mockMvc.perform(get("/courses/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Course Service"));

    }

    @Test
    public void testGetAllCoursesWhenNoneExist() throws Exception {
        // Extract CourseService from CourseController
        // Rename existing CourseService to CourseServiceApplication or CourseServiceRunner
        // In CourseServiceTest:
            // Mock CourseService dependencies
            // Mock return value of courses
            // Test against mock
        // Here:
            // Hit courses endpoint
            // Check against expected value NOTE: was Justin mocking this?
    }

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
