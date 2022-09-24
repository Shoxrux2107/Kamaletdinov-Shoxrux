package com.example.model;

import com.example.model.Employee;
import com.example.model.Profession;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfessionDao {

    public final JdbcTemplate jdbcTemplate;
    public List<Profession> view () {
        String sql = "select * from profession";

        return jdbcTemplate.query(sql, (rs, row) ->
                Profession.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .requirements(rs.getString(3))
                        .build()

        );

    }


}
