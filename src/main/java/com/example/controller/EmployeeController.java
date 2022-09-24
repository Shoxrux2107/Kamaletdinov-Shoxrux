package com.example.controller;


import com.example.model.DepartmentDao;
import com.example.model.EmployeeDao;
import com.example.model.ProfessionDao;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.Profession;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {
    public final EmployeeDao employeeDao;

    public final ProfessionDao professionDao;
    public final DepartmentDao departmentDao;

    @GetMapping
    public String viewAll(Model model){
        List<Employee> employees =employeeDao.view();
        model.addAttribute("listEmp", employees);
        return "viewEmployee";
            }

            @GetMapping("/get-form")
            public String form(Model model){
        List<Profession> professionList =professionDao.view();
        List<Department> departmentList =departmentDao.view();
        model.addAttribute("prof",professionList);
        model.addAttribute("depart", departmentList);
        return "formEmployee";
            }


    @PostMapping("/save")
    public String add(Employee employee){
        employeeDao.addEmp(employee);

        return "redirect:/emp";
        }



        @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Employee employee =employeeDao.empById(id);
        model.addAttribute("emp", employee);
        return "editEmployee";
        }


        @PostMapping("/editSave")
    public String editSave(Employee employee){
        employeeDao.saveEdit(employee);
        return "redirect:/emp";
        }

@GetMapping("/delete/{id}")
        public String delete (@PathVariable Integer id){

        employeeDao.delete(id);
    return "redirect:/emp";
}


}
