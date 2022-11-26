package com.skypro.emploee.service;

import com.skypro.emploee.Record.EmployeeRequest;
import com.skypro.emploee.model.Emploee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmploeeService {
    private final Map<Integer, Emploee> employees = new HashMap<>();


    public Collection<Emploee> getAllEmploees() {
        return this.employees.values();
    }

    public Emploee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Введитте правильно имя и фамилию");
        }
        Emploee emploee = new Emploee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(emploee.getId(),emploee);
        return emploee;
    }

    public int getSalarySum() {
        return employees.values().stream().mapToInt(e->e.getSalary()).sum();
    }
}
