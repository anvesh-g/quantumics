package com.quantumics.quantumics.service;

import com.quantumics.quantumics.entity.Employee;
import com.quantumics.quantumics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<com.corptec.assignment.model.Employee> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        return getEmployeeModel(employees);
    }

    public List<com.corptec.assignment.model.Employee> saveAllEmployees(List<com.corptec.assignment.model.Employee> employees) {
        List<Employee> employeeList = setEmployeeEntity(employees);
        List<Employee> savedEmployees = this.employeeRepository.saveAll(employeeList);
        return getEmployeeModel(savedEmployees);
    }

    public List<Employee> setEmployeeEntity(List<com.corptec.assignment.model.Employee> employees) {
       return employees.stream().map(employee -> {
            return Employee.builder()
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .gender(employee.getGender())
                    .emailId(employee.getEmailId())
                    .dateOfBirth(employee.getDateOfBirth())
                    .dateOfJoining(employee.getDateOfJoining())
                    .salary(employee.getSalary())
                    .build();
        }).collect(Collectors.toList());
    }

    public List<com.corptec.assignment.model.Employee> getEmployeeModel(List<Employee> employees) {
        List<com.corptec.assignment.model.Employee> employeeList = employees.stream().map(employee -> {
            return com.corptec.assignment.model.Employee.builder()
                    .id(employee.getEmployeeId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .gender(employee.getGender())
                    .emailId(employee.getEmailId())
                    .dateOfBirth(employee.getDateOfBirth())
                    .dateOfJoining(employee.getDateOfJoining())
                    .salary(employee.getSalary())
                    .build();
        }).collect(Collectors.toList());
        return employeeList;
    }

}
