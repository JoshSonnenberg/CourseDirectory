package com.solstice.courseservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class EnrollmentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<String> rowMapper = (ResultSet resultSet, int row) -> resultSet.getString("courseId");


    public EnrollmentRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    private final String COURSE_BY_ID_QUERY = "select courseId from enrollment where employeeId = ? and completed=\"Y\"";
    public List<String> getCompletedCourseIdsForEmployee(String employeeId) {
        return this.jdbcTemplate.query(COURSE_BY_ID_QUERY, new Object[]{employeeId}, rowMapper);
    }

    private final String EMPLOYEE_BY_ID_QUERY = "select employeeId from enrollment where courseId = ? and completed=\"Y\"";


}
