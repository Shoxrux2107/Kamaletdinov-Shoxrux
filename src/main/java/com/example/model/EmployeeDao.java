package com.example.model;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class EmployeeDao {


    private final JdbcTemplate jdbcTemplate;


     public List<Employee> view () {
         String sql = "select * from employee";

         return jdbcTemplate.query(sql, (rs, row) ->
                 Employee.builder()
                         .id(rs.getInt(1))
                         .name(rs.getString(2))
                         .email(rs.getString(3))
                         .biography(rs.getString(4))
                         .profession_id(rs.getInt(5))
                         .department_id(rs.getInt(6))
                         .build()

         );

     }



         public int addEmp(Employee employ){
             String sql= "Insert into employee(name, email, biography, " +
                     "profession_id, department_id) values (?,?,?,?,?)";
             return jdbcTemplate.update(sql, employ.getName(), employ.getEmail(),
                     employ.getBiography(), employ.getProfession_id(), employ.getBiography());
         }


         public Employee empById(Integer id){
         String sql= "Select * from employee where id="+id;
         return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
         }



         public int saveEdit(Employee employ){

         String sql ="update employee set name=?, email=?, biography=?, profession_id=?, department_id=? where id =?"+employ.getId();
         return jdbcTemplate.update(sql,employ.getName(), employ.getEmail(),
                 employ.getBiography(), employ.getProfession_id(), employ.getBiography() );

     }



        public int delete (Integer id){

         String sql = "delete from employee  where id="+id;
         return jdbcTemplate.update(sql);
        }

     }











