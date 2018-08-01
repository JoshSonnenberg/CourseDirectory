package com.solstice.courseservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<CourseRecord> rowMapper = (ResultSet resultSet, int row) -> new CourseRecord(
            resultSet.getString("id"),
            resultSet.getString("name"),
            resultSet.getString("tags")
    );

    public CourseRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    private final String SQL_QUERY_COURSES = "select * from course";

    public List<CourseRecord> getAll() {
        return this.jdbcTemplate.query(SQL_QUERY_COURSES, rowMapper);
    }

    public final String QUERY_BY_TAG = "select * from course where tags like ";
    public List<CourseRecord> getAllByTag(String tag) {
        String tagQuery = "\"%" + tag + "%\"";
        String fullQuery = QUERY_BY_TAG + tagQuery;

        return this.jdbcTemplate.query(fullQuery, rowMapper);
    }

    public final String QUERY_BY_IDS = "select * from course where id in ";
    public List<CourseRecord> getCoursesByIds(List<String> ids) {
        List<String> queryIds = ids.stream().map(id -> "\"" + id + "\"").collect(Collectors.toList());
        String finalQuery = QUERY_BY_IDS + "(" + String.join(", ", queryIds) + ")";
        return this.jdbcTemplate.query(finalQuery, rowMapper);
    }
}
