package com.solstice.courseservice.controllers;

import com.solstice.courseservice.course.model.CourseInfo;
import com.solstice.courseservice.course.service.CourseService;
import com.solstice.courseservice.enrollment.database.EnrollmentRepository;
import com.solstice.courseservice.enrollment.service.EnrollmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {



    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final EnrollmentRepository enrollmentRepository;


    public CourseController(CourseService courseService, EnrollmentService enrollmentService, EnrollmentRepository enrollmentRepository) {
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.enrollmentRepository = enrollmentRepository;
    }

    // Get Requests

    @GetMapping("/greeting")
    public String greeting() {
        return courseService.greeting();
    }

    @GetMapping
    public List<CourseInfo> courses() {
        return courseService.courses();
    }

    @GetMapping("tag/{tagName}")
    public List<CourseInfo> coursesByTag(@PathVariable("tagName") String tag) {
        return courseService.coursesByTag(tag);
    }

    @GetMapping("employeeId/tag/{tagName}")
    public List<String> employeeIdsByCourseIds(@PathVariable("tagName") String tag) {
        List<String> courseIds = this.courseService.courseIdsByTag(tag);
        return this.enrollmentService.employeeIdsByCourseIds(courseIds);
    }
/*
    @GetMapping("employee/{id}")
    public List<CourseInfo> completedCoursesByEmployeeId(@PathVariable("id") String id) {
        List<String> courseIds = enrollmentRepository.getCompletedCourseIdsForEmployee(id);
        if (courseIds.size() == 0)
            return null;

        return this.coursesByIds(courseIds);
    }

    // POST Requests

    @PostMapping("/enrollment")
    public ResponseEntity<EnrollmentInfo> add(@RequestBody NewEnrollmentFields newEnrollmentFields) {
        EnrollmentInfo info = enrollmentRepository.save(newEnrollmentFields);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(buildEnrollmentUri(info));

        return new ResponseEntity<>(info, httpHeaders, HttpStatus.CREATED);
    }

    // PUT Requests

    @PutMapping("course/tags")
    public ResponseEntity<CourseInfo> modify(@RequestBody UpdateTagsFields updateTagsFields) {
        CourseInfo info = coursePresenter.present(courseRepository.update(updateTagsFields.courseId, updateTagsFields.tags));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(buildCourseUri(info));

        return new ResponseEntity<>(info, httpHeaders, HttpStatus.ACCEPTED);
    }

    // Helpers

    private URI buildCourseUri(CourseInfo info) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/" + info.id + "/" + info.tags)
                .buildAndExpand()
                .toUri();
    }

    private URI buildEnrollmentUri(EnrollmentInfo info) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/" + info.employeeId + "/" + info.courseId)
                .buildAndExpand()
                .toUri();
    }

    private List<CourseInfo> coursesByIds(List<String> ids) {
        return courseRepository.getCoursesByIds(ids)
                .stream()
                .map(coursePresenter::present)
                .collect(toList());
    }

*/

}