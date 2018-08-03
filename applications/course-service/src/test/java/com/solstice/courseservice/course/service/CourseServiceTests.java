package com.solstice.courseservice.course.service;

import com.solstice.courseservice.course.database.CourseRepository;
import com.solstice.courseservice.course.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CourseServiceTests {


    @Mock
    private CourseRepository courseRepository;

    private CourseService courseService;

    @Before
    public void setup() {
        this.courseService = new CourseService(courseRepository);
    }

    @Test
    public void greeting() {
        assertEquals(courseService.greeting(), "Course Service");
    }

    @Test
    public void courses_returnsListOfCourses() {
        List<CourseRecord> expectedCourseRecords = Arrays.asList(new CourseRecord("1", "Testing 101","test"));
        List<CourseInfo> expectedCourseInfo = Arrays.asList(new CourseInfo("1", "Testing 101", "test"));

        when(courseRepository.getAll()).thenReturn(expectedCourseRecords);

        List<CourseInfo> actualCourses = courseService.courses();
        assertThat(actualCourses).isEqualTo(expectedCourseInfo);
    }

    @Test
    public void coursesByTag_returnsListOfCourses() {
        List<CourseRecord> expectedCourseRecords = Arrays.asList(new CourseRecord("1", "Testing 101","test"));
        List<CourseInfo> expectedCourseInfo = Arrays.asList(new CourseInfo("1", "Testing 101", "test"));

        when(courseRepository.getAllByTag("test")).thenReturn(expectedCourseRecords);

        List<CourseInfo> actualCourses = courseService.coursesByTag("test");
        assertThat(actualCourses).isEqualTo(expectedCourseInfo);
    }

    @Test
    public void coursesByTag_returnsEmptyList() {
        List<CourseRecord> expectedCourseRecords = Arrays.asList();
        List<CourseInfo> expectedCourseInfo = Arrays.asList();

        when(courseRepository.getAllByTag("test")).thenReturn(expectedCourseRecords);

        List<CourseInfo> actualCourses = courseService.coursesByTag("test");
        assertThat(actualCourses).isEqualTo(expectedCourseInfo);
    }

    @Test
    public void courseIdsByTag_returnsListOfCourseIds() {
        List<CourseRecord> expectedCourseRecords = Arrays.asList(new CourseRecord("1", "Testing 101","test"));
        List<String> expectedCourseIds = Arrays.asList("1");

        when(courseRepository.getAllByTag("test")).thenReturn(expectedCourseRecords);

        List<String> actualCourseIds = courseService.courseIdsByTag("test");
        assertThat(actualCourseIds).isEqualTo(expectedCourseIds);
    }

    @Test
    public void courseIdsByTag_returnsEmptyList() {
        List<CourseRecord> expectedCourseRecords = Arrays.asList();
        List<String> expectedCourseIds = Arrays.asList();

        when(courseRepository.getAllByTag("test")).thenReturn(expectedCourseRecords);

        List<String> actualCourseIds = courseService.courseIdsByTag("test");
        assertThat(actualCourseIds).isEqualTo(expectedCourseIds);
    }

}
