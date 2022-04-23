package com.basics.javabasics;

public class Employee {
    private String name, department;
    public Employee(String name, String department)
    {
        this.name = name;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
}
