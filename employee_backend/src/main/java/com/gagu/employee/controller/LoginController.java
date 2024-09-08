package com.gagu.employee.controller;

import com.gagu.employee.entity.Employee;
import com.gagu.employee.model.EmployeeLogin;
import com.gagu.employee.serviceImpl.EmployeeServiceImpl;
import com.gagu.employee.serviceImpl.EmployeeVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth/")
public class LoginController {

    @Autowired
    EmployeeVerify employeeVerify;

    @GetMapping("/loginUser")
    public ResponseEntity<String> login(@RequestBody EmployeeLogin employeeLogin) {
        return ResponseEntity.ok(employeeVerify.verifyUser(employeeLogin));
    }
    @GetMapping("/logoutUser")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Hello World from logout");
    }
}
