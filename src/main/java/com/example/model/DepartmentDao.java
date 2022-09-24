package com.example.model;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.Profession;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentDao {
    public final JdbcTemplate jdbcTemplate;
    public List<Department> view() {

        String sql = "select * from employee";

        return jdbcTemplate.query(sql, (rs, row) ->
                Department.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .description(rs.getString(3))

                        .build()

        );


    }




}
