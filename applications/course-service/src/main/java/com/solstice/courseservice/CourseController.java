package com.solstice.courseservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Course Service";
    }

    @GetMapping
    public List<CourseInfo> courses() {
        return null;
    }
}