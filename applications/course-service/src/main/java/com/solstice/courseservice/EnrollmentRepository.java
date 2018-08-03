package com.solstice.courseservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;

@Repository
public class EnrollmentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<EnrollmentInfo> entityMapper = (ResultSet resultSet, int row) ->  new EnrollmentInfo(
            resultSet.getString("employeeId"),
            resultSet.getString("courseId"),
            resultSet.getString("completed").equals("Y"));
    private final RowMapper<String> rowMapper = (ResultSet resultSet, int row) -> resultSet.getString("courseId");
    private final RowMapper<String> employeeRowMapper = (ResultSet resultSet, int row) -> resultSet.getString("employeeId");

    public EnrollmentRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    private final String COURSE_BY_ID_QUERY = "select courseId from enrollment where employeeId = ? and completed=\"Y\"";
    public List<String> getCompletedCourseIdsForEmployee(String employeeId) {
        return this.jdbcTemplate.query(COURSE_BY_ID_QUERY, new Object[]{employeeId}, rowMapper);
    }

    private final String EMPLOYEE_BY_ID_QUERY = "select employeeId from enrollment where completed=\"Y\" and courseId in ";
    public List<String> getEmployeeIdsByCourseIds(List<String> ids) {
        List<String> queryIds = ids.stream().map(id -> "\"" + id + "\"").collect(Collectors.toList());
        String queryParameter = "(" + String.join(", ", queryIds) + ")";
        String finalQuery = EMPLOYEE_BY_ID_QUERY + queryParameter;
        return this.jdbcTemplate.query(finalQuery, employeeRowMapper);
    }

    private final String SAVE_ENROLLMENT = "insert into enrollment (employeeId, courseId, completed)" +
            " values(?, ?, ?)";
    public EnrollmentInfo save(NewEnrollmentFields newEnrollmentFields) {
        jdbcTemplate.update(SAVE_ENROLLMENT, newEnrollmentFields.employeeId, newEnrollmentFields.courseId, newEnrollmentFields.completed);

        return findEnrollment(newEnrollmentFields.employeeId, newEnrollmentFields.courseId);
    }

    private final String FIND_ENROLLMENT = "select * from enrollment where employeeId = ? and courseId = ?";
    private EnrollmentInfo findEnrollment(String employeeId, String courseId) {
        return jdbcTemplate.queryForObject(FIND_ENROLLMENT, new Object[]{employeeId, courseId}, entityMapper);
    }

}
