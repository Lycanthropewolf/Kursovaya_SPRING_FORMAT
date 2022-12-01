package com.skypro.emploee.service;

import com.skypro.emploee.Record.EmployeeRequest;
import com.skypro.emploee.model.Emploee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmploeeService {
    private final Map<Integer, Emploee> employees = new HashMap<>();


    public Collection<Emploee> getAllEmploees(  ) {
         return this.employees.values();
    }

    public Emploee addEmployee( EmployeeRequest employeeRequest ) {
        if (StringUtils.isEmpty(employeeRequest.getFirstName()) || StringUtils.isBlank(employeeRequest.getFirstName())) {
            System.out.println("Заполните правильно имя сотрудника");
        } else if (StringUtils.isEmpty(employeeRequest.getLastName()) || StringUtils.isBlank(employeeRequest.getLastName())) {
            System.out.println("Заполните правильно фамилию сотрудника");
        }
        Emploee emploee = new  Emploee(
                StringUtils.capitalize(employeeRequest.getFirstName()),
                StringUtils.capitalize(employeeRequest.getLastName()),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put( emploee.getId(), emploee );
        return emploee;
    }

    public int getSalarySum( ) {
        return employees.values().stream().mapToInt(e ->  e.getSalary()).sum();
    }


    public Optional<Emploee> getEmloyeeSalaryMax( ) {
        return employees.values().stream().max(Comparator.comparingInt(Emploee::getSalary));
    }

    public Optional<Emploee> getEmloyeeSalaryMin( ) {
         return employees.values().stream().min(Comparator.comparingInt(Emploee::getSalary));
    }

    public List<Emploee> getEmloyeeSalaryHigh( ) {
         double middle = employees.values().stream()
                .mapToInt(Employee -> Employee.getSalary())
                .average().orElse(0);
         return employees.values().stream()
                .filter(e->e.getSalary()>middle).collect(Collectors.toList());
    }
}

