package com.skypro.emploee.controller;

import com.skypro.emploee.Record.EmployeeRequest;
import com.skypro.emploee.model.Emploee;
import com.skypro.emploee.service.EmploeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmploeeController {
    private final EmploeeService emploeeService;

    public EmploeeController(EmploeeService emploeeService) {
        this.emploeeService = emploeeService;
    }

    @GetMapping("/employees")
    public Collection<Emploee> getAllEmployees() {
        return this.emploeeService.getAllEmploees();
    }

    @PostMapping("/employees")
    public Emploee createEmployeee(@RequestBody EmployeeRequest employeeRequest) {
        return this.emploeeService.addEmployee(employeeRequest);
    }

    @GetMapping("employees/salary/sum")
    public int getSalarySum() {
        return this.emploeeService.getSalarySum();
    }
}
