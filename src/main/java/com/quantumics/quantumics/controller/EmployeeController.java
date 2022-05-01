package com.quantumics.quantumics.controller;

import com.quantumics.quantumics.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {


    @Autowired
    public EmployeeService employeeService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<com.corptec.assignment.model.Employee>> getAllEmployee() {
        List<com.corptec.assignment.model.Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<com.corptec.assignment.model.Employee>> getAllEmployee(@RequestBody List<com.corptec.assignment.model.Employee> employees) {
        List<com.corptec.assignment.model.Employee> savedEmployees = employeeService.saveAllEmployees(employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.OK);
    }

}
