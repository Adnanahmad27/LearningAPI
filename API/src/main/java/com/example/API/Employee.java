package com.example.API;

public class Employee {
    private int employeeId;
    private String team;

    public Employee(int employeeId, String team) {
        this.employeeId = employeeId;
        this.team = team;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getTeam() {
        return team;
    }
}
