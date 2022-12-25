package com.skypro.emploee.service;

import com.skypro.emploee.model.Emploee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmploeeService emploeeService;

    public DepartmentService(EmploeeService emploeeService) {
        this.emploeeService = emploeeService;
    }

    public Set<Integer> getExistingDepartments() {
        return emploeeService.getAllEmploees().stream().map(Emploee::getDepartment).collect(Collectors.toSet());
    }


    public List<Emploee> getEmployeeesFromDepartment(int departmentId) {
        return emploeeService.getAllEmploees().stream().filter(emploee -> emploee.getDepartment() == departmentId).collect(Collectors.toList());
    }

    public Map<Integer, List<Emploee>> getEmployeeesByDepartment() {
        return getExistingDepartments().stream().collect(Collectors.toMap(dept -> dept, this::getEmployeeesFromDepartment));
    }

    public int getSalarySumOfDepartment(int departmentId) {
        return getEmployeeesFromDepartment(departmentId).stream().mapToInt(Emploee::getSalary).sum();
    }

    public int getMinSalaryOfDepartment(int departmentId) {
        return getEmployeeesFromDepartment(departmentId).stream().mapToInt(Emploee::getSalary).min().orElseThrow();
    }

    public int getMaxSalaryOfDepartment(int departmentId) {
        return getEmployeeesFromDepartment(departmentId).stream().mapToInt(Emploee::getSalary).max().orElseThrow();
    }

}
