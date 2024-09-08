package com.gagu.employee.controller;

import com.gagu.employee.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class HomeController {

@GetMapping("homeUser")
    public String userHome(@RequestBody Employee employee) {
    return "Hello World "+employee.toString();
}
}
