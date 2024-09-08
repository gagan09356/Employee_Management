package com.gagu.employee.serviceImpl;

import com.gagu.employee.model.EmployeeLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class EmployeeVerify {

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public String verifyUser(EmployeeLogin employeeLogin) {
        Authentication authenticate= authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        employeeLogin.username(), employeeLogin.password()));
        if(authenticate.isAuthenticated()) {
            String token=jwtService.generateToken(employeeLogin.username());
            return token;
            //if user is valid we need to generate the JWTtoken
        }
        else
        return "invalid User";
    }
}
