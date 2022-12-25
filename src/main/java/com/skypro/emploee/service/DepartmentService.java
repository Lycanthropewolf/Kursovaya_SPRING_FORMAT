package com.skypro.emploee.service;

import com.skypro.emploee.model.Emploee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    private final EmploeeService emploeeService;

    public DepartmentService(EmploeeService emploeeService) {
        this.emploeeService = emploeeService;
    }



    public Collection<Emploee> getEmployeeesFromDepartment(int departmentId) {
        return emploeeService.getEmployeesByDepartmentStream(departmentId)
    }


    public Map<Integer, List<Emploee>> getEmployeeesByDepartment() {
        return emploeeService.getAllEmploees().stream().collect(Collectors.groupingBy(Emploee::getDepartment));
    }

    private Stream<Emploee> getEmployeesByDepartmentStream(int departmentId) {
        return emploeeService.getAllEmploees().stream().filter(e -> e.getDepartment() == departmentId);
    }


}
