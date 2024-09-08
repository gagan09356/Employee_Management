package com.gagu.employee.controller;

import com.gagu.employee.entity.Employee;
import com.gagu.employee.service.EmployeeRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired
    EmployeeRegService employeeRegService;

    @PostMapping("/register")
    public ResponseEntity<Employee> register(@RequestBody Employee employee) {
            System.out.println(employee.getRole());
            System.out.println(employee.getUsername());
            return (ResponseEntity<Employee>) ResponseEntity.ok(employeeRegService.employeeReg(employee));
    }
}
