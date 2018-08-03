package com.solstice.courseservice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.Path;
import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CoursePresenter coursePresenter;
    private final EnrollmentRepository enrollmentRepository;


    public CourseController(CourseRepository courseRepository, CoursePresenter coursePresenter, EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.coursePresenter = coursePresenter;
        this.enrollmentRepository = enrollmentRepository;
    }

    // Get Requests

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

    @GetMapping("employeeId/tag/{tagName}")
    public List<String> courseIdByTag(@PathVariable("tagName") String tag) {
        List<CourseInfo> courseInfo = this.coursesByTag(tag);
        List<String> ids = courseInfo.stream().map(info -> info.id).collect(toList());
        if (ids.size() == 0) {
            return ids;
        }

        return this.employeeIdsByCourseIds(ids);
    }

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

    private List<String> employeeIdsByCourseIds(List<String> courseIds) {
        List<String> employeeIds = enrollmentRepository.getEmployeeIdsByCourseIds(courseIds);
        if (employeeIds.size() == 0)
            return employeeIds;

        return employeeIds;
    }

}