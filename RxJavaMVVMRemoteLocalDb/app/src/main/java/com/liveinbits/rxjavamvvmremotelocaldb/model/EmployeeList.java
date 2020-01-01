package com.liveinbits.rxjavamvvmremotelocaldb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeList {
    @SerializedName("records")
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
