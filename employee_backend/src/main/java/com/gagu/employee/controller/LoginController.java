package com.gagu.employee.controller;

import com.gagu.employee.model.EmployeeLogin;
import com.gagu.employee.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth/")
public class LoginController {

    /*@GetMapping("/register")
    public  ResponseEntity<String> register(){
        return ResponseEntity.ok("Registered");
    }*/
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/loginUser")
    public ResponseEntity<String> login(@RequestBody EmployeeLogin employeeLogin) {
        //employeeService.
       return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/logoutUser")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Hello World from logout");
    }
}
