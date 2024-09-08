package com.gagu.employee.service;

import com.gagu.employee.model.EmployeeLogin;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService extends UserDetailsService {

}
