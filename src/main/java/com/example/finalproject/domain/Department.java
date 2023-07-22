package com.example.finalproject.domain;

import java.util.Date;

public class Department {
    private int id;
    private String name;
    private String departmentCode;
    private String description;
    private Date issueDate;
    private Department parentId;

    public Department() {
    }

    public Department(int id, String name, String departmentCode, String description, Date issueDate, Department parentId) {
        this.id = id;
        this.name = name;
        this.departmentCode = departmentCode;
        this.description = description;
        this.issueDate = issueDate;
        this.parentId = parentId;
    }

    public void setParentId(Department parentId) {
        this.parentId = parentId;
    }

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
}
