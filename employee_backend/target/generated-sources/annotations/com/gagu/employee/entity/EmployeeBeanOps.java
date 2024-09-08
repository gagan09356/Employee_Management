package com.gagu.employee.entity;

sealed abstract class EmployeeBeanOps extends java.lang.Object permits Employee {

    private Employee self() {
        return (switch (this) { case Employee __ -> __; });
    }

    /**
     * Creates an instance of Employee.
     */
    public static Employee of(
        java.lang.Integer id,
        java.lang.String username,
        java.lang.String email,
        java.lang.String password,
        java.lang.String role
    ) {
        var o$ = new Employee();
        o$.setId(id);
        o$.setUsername(username);
        o$.setEmail(email);
        o$.setPassword(password);
        o$.setRole(role);
        return o$;
    }

    /**
     * Get the current value for id.
     */
    public java.lang.Integer getId() {
        return self().id;
    }

    /**
     * Set the current value for id.
     */
    public void setId(java.lang.Integer id) {
        self().id = id;
    }

    /**
     * Get the current value for username.
     */
    public java.lang.String getUsername() {
        return self().username;
    }

    /**
     * Set the current value for username.
     */
    public void setUsername(java.lang.String username) {
        self().username = username;
    }

    /**
     * Get the current value for email.
     */
    public java.lang.String getEmail() {
        return self().email;
    }

    /**
     * Set the current value for email.
     */
    public void setEmail(java.lang.String email) {
        self().email = email;
    }

    /**
     * Get the current value for password.
     */
    public java.lang.String getPassword() {
        return self().password;
    }

    /**
     * Set the current value for password.
     */
    public void setPassword(java.lang.String password) {
        self().password = password;
    }

    /**
     * Get the current value for role.
     */
    public java.lang.String getRole() {
        return self().role;
    }

    /**
     * Set the current value for role.
     */
    public void setRole(java.lang.String role) {
        self().role = role;
    }

    @Override
    public String toString() {
        return "Employee[" + "id=" + self().id +
                     ", " + "username=" + self().username +
                     ", " + "email=" + self().email +
                     ", " + "password=" + self().password +
                     ", " + "role=" + self().role + "]";
    }

}