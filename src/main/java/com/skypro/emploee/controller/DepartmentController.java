package com.skypro.emploee.controller;


import com.skypro.emploee.model.Emploee;
import com.skypro.emploee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String getExistingDepartments() {
        return "Existing Departments:" + departmentService.getExistingDepartments().toString();
    }

    @GetMapping("/employees")
    public Map<Integer, List<Emploee>> getEmployeeesByDepartment() {
        return departmentService.getEmployeeesByDepartment();
    }

    @GetMapping("/{id}/employees")
    public Collection<Emploee> getEmployeeesFromDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeesFromDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOfDepartment(@PathVariable("id")int departmentId){
        return departmentService.getSalarySumOfDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/min")
    public int getMinSalaryOfDepartment(@PathVariable("id")int departmentId){
        return departmentService.getMinSalaryOfDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/max")
    public int  getMaxSalaryOfDepartment(@PathVariable("id")int departmentId){
        return departmentService.getMaxSalaryOfDepartment(departmentId);
    }








}
