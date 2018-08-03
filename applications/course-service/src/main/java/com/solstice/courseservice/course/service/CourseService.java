package com.solstice.courseservice.course.service;

import com.solstice.courseservice.course.database.CourseRepository;
import com.solstice.courseservice.course.model.CourseInfo;
import com.solstice.courseservice.course.util.CoursePresenter;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CourseService {

    private final CourseRepository courseRepository;


    public CourseService(CourseRepository repository) {
        this.courseRepository = repository;
    }

    public String greeting() {
        return "Course Service";
    }

    public List<CourseInfo> courses() {
        return courseRepository.getAll()
                .stream()
                .map(CoursePresenter::present)
                .collect(toList());
    }

    public List<CourseInfo> coursesByTag(String tag) {
        return courseRepository.getAllByTag(tag)
                .stream()
                .map(CoursePresenter::present)
                .collect(toList());
    }

    public List<String> courseIdsByTag(String tag) {
        List<CourseInfo> courseInfo = this.coursesByTag(tag);
        List<String> ids = courseInfo.stream().map(info -> info.id).collect(toList());

        return ids;
    }

}
