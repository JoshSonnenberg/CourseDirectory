package com.solstice.employeeservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepository {
    public static List<EmployeeRecord> getEmployeesByCourseId(String courseId) {
        return null;
    }

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<EmployeeRecord> rowMapper = (ResultSet resultSet, int row) -> new EmployeeRecord(
            resultSet.getString("id"),
            resultSet.getString("firstName"),
            resultSet.getString("lastName"),
            resultSet.getInt("employeeNumber"),
            resultSet.getString("office"),
            resultSet.getString("title"),
            resultSet.getString("email"),
            resultSet.getString("imageURL")
    );

    public EmployeeRepository (JdbcTemplate template){
        this.jdbcTemplate = template;
    }


}
