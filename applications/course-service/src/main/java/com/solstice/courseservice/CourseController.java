package com.solstice.courseservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CoursePresenter coursePresenter;

    public CourseController(CourseRepository courseRepository, CoursePresenter coursePresenter) {
        this.courseRepository = courseRepository;
        this.coursePresenter = coursePresenter;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Course Service";
    }

    @GetMapping
    public List<CourseInfo> courses() {
        return courseRepository.getAll()
                .stream()
                .map(coursePresenter::present)
                .collect(toList());
    }

    @GetMapping("tag/{tagName}")
    public List<CourseInfo> coursesByTag(@PathVariable("tagName") String tag) {
        return courseRepository.getAllByTag(tag)
                .stream()
                .map(coursePresenter::present)
                .collect(toList());
    }
}