package com.example.finalproject.service.dto;

import java.sql.Date;

public class DepartmentDTO {
    private int id;
    private String name;
    private String departmentCode;
    private String description;
    private Date issueDate;
    private DepartmentDTO parentDepartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public DepartmentDTO getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(DepartmentDTO parentDepartment) {
        this.parentDepartment = parentDepartment;
    }
}
