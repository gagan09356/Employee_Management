package com.gagu.employee.serviceImpl;

import com.gagu.employee.entity.Employee;
import com.gagu.employee.repo.EmployeeRepo;
import com.gagu.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Employee employee = employeeRepo.findByUsername(username);
       if (employee == null) {
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       else{
          return User.builder()
                   .username(employee.getUsername())
                   .password(employee.getPassword())
                   .roles(employee.getRole())
                   .build();
       }

    }



}
