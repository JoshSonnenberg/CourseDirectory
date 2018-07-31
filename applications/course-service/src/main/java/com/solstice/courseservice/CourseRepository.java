package com.solstice.courseservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class CourseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<CourseInfo> rowMapper = (ResultSet resultSet, int row) -> new CourseInfo(
            resultSet.getString("id"),
            resultSet.getString("name"),
            resultSet.getString("tags")
    );

    public CourseRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

}
