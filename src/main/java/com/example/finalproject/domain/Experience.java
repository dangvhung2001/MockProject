package com.example.finalproject.domain;

import java.sql.Date;

public class Experience {
    private Long id;

    private String name_experience;
    private Date timeStart;
    private Date timeEnd;
    private String language;
    private String link;
    private String workplace;
    private String position;
    private int teamSize;
    private String description;
    private String os;
    private String framework;
    private Employee employee; // Many-to-One relationship with Employee

    public Experience() {
    }

    public Experience(Long id, Date timeStart, Date timeEnd, String language, String link, String workplace, String position, String technologiesUsed, int teamSize, String description, String os, String framework, Employee employee,String name_experience) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.language = language;
        this.link = link;
        this.workplace = workplace;
        this.position = position;
        this.name_experience = name_experience;
        this.teamSize = teamSize;
        this.description = description;
        this.os = os;
        this.framework = framework;
        this.employee = employee;
    }

    public String getName_experience() {
        return name_experience;
    }

    public void setName_experience(String name_experience) {
        this.name_experience = name_experience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
