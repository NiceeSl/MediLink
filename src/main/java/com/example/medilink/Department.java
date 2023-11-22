package com.example.medilink;

public class Department {
    private int departmentId;
    private String departmentName;
    private String location;
    private String phone;

    public Department(int departmentId, String departmentName, String location, String phone) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
        this.phone = phone;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
