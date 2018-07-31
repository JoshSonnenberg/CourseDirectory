package com.solstice.courseservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    public CourseController() {}

    @GetMapping("/")
    public String greeting() {
        return "Course Service";
    }


}