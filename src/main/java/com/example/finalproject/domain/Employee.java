package com.example.finalproject.domain;

import java.util.*;
import java.sql.Date;

public class Employee {
    private Long id;
    private String imgUrl;
    private String firstname;
    private String lastname;
    private String password;
    private Date createdAt;
    private int sex;
    private String maritalStatus;
    private Date dateOfBirth;
    private String citizenCode;
    private Date issueDate;
    private String placeOfIssue;
    private String employeeCode;
    private String email;
    private String address;
    private int phone;
    private Date startDate;
    private float salaryCoefficient;
    private float salary;
    private String position;
    private String educationLevel;
    private Employee manager;
    private Department department;
    private Set<Role> roles = new HashSet<>();

    public Employee() {
    }

    public Employee(Long id, String imgUrl, String firstname, String lastname, String password, Date createdAt, int sex, String maritalStatus, Date dateOfBirth, String citizenCode, Date issueDate, String placeOfIssue, String employeeCode, String email, String address, int phone, Date startDate, float salaryCoefficient, float salary, String position, String educationLevel, Employee manager, Department department, Set<Role> roles) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.createdAt = createdAt;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.dateOfBirth = dateOfBirth;
        this.citizenCode = citizenCode;
        this.issueDate = issueDate;
        this.placeOfIssue = placeOfIssue;
        this.employeeCode = employeeCode;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.startDate = startDate;
        this.salaryCoefficient = salaryCoefficient;
        this.salary = salary;
        this.position = position;
        this.educationLevel = educationLevel;
        this.manager = manager;
        this.department = department;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenCode() {
        return citizenCode;
    }

    public void setCitizenCode(String citizenCode) {
        this.citizenCode = citizenCode;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(float salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
