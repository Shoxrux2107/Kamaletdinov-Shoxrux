package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
        private Integer id;
        private String name;
        private String email;
        private String biography;
        private Integer profession_id;
        private Integer department_id;
   }


