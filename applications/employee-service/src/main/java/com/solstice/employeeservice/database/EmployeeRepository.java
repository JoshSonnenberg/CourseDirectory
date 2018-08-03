package com.solstice.employeeservice.database;

import com.solstice.employeeservice.models.EmployeeRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    public final String QUERY_BY_IDS = "select * from employee where id in ";

    public List<EmployeeRecord> getEmployeesByIds(List<String> employeeIds) {
        List<String> queryIds = employeeIds.stream().map(id -> "\"" + id + "\"").collect(Collectors.toList());
        String finalQuery = QUERY_BY_IDS + "(" + String.join(", ", queryIds) + ")";
        return this.jdbcTemplate.query(finalQuery, rowMapper);
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