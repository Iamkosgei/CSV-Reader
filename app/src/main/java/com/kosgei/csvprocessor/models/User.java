package com.kosgei.csvprocessor.models;

import java.util.Date;
import java.util.List;

public class User {
    private String fullNames;
    private Date dateOfBirth;
    private  double height;
    private boolean isActive;
    private List<String> roles;

    public User() {
    }

    public User(String fullNames, Date dateOfBirth, double height, boolean isActive, List<String> roles) {
        this.fullNames = fullNames;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.isActive = isActive;
        this.roles = roles;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
