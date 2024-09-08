package com.gagu.employee.entity;

sealed abstract class AppleBeanOps extends java.lang.Object permits Apple {

    private Apple self() {
        return (switch (this) { case Apple __ -> __; });
    }

    /**
     * Get the current value for name.
     */
    public java.lang.String getName() {
        return self().name;
    }

    /**
     * Set the current value for name.
     */
    public void setName(java.lang.String name) {
        self().name = name;
    }

}