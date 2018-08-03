package com.solstice.courseservice.controllers;

import com.solstice.courseservice.controllers.CourseController;
import com.solstice.courseservice.course.database.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseController courseController;
    CourseRepository courseRepository;

    @Test
    public void testGreeting() throws Exception {
        this.mockMvc.perform(get("/courses/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Course Service"));

    }

    @Test
    public void courses() throws Exception {
        String expectedJson = "[{\"id\":\"66921076-eeee-458b-9d7d-ce9a227d64a5\",\"name\":\"Solstice 102\",\"tags\":\"test, solstice\"},{\"id\":\"66921076-fdse-458b-9d7d-ce9a227d64a5\",\"name\":\"Solstice 101\",\"tags\":\"intro, solstice\"}]";
        this.mockMvc.perform(get("courses"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
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
//        CourseController controllers = new CourseController(courseRepository);
//        CourseInfo expectedCourse = new CourseInfo();
//        assertEquals(controllers.courses().size(), 1);
//        assertEquals(controllers.courses().get(0), expectedCourse);
//    }

}
