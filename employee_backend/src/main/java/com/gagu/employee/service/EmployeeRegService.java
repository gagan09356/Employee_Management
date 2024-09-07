package com.gagu.employee.service;

import com.gagu.employee.entity.Employee;
import com.gagu.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRegService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee employeeReg(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepo.save(employee);
    }
}
