package com.gagu.employee.entity;

import dev.mccue.magicbean.MagicBean;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@MagicBean(toString_ = true, allArgsStaticFactory = true)
@Table(name="Employee")
public non-sealed class  Employee extends EmployeeBeanOps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
     String username;
     String email;
     String password;
     String role;

}
