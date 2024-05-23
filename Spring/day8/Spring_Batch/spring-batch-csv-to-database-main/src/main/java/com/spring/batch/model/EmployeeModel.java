package com.spring.batch.model;

import java.io.Serializable;


/**
 * The Class EmployeeModel.
 * <p>
 * Class description explaining the usage.
 * </p>
 */
public class EmployeeModel implements Serializable {

    /**
     * long holds the serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private long employeeId;

    private String employeeName;

    private String employeeRole;

    private String salary;

    private long yearOfExperience;

    /**
     * @param employeeId
     * @param employeeName
     * @param employeeRole
     * @param salary
     * @param yearOfExperience
     */
    public EmployeeModel(long employeeId, String employeeName, String employeeRole, String salary, long yearOfExperience) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.salary = salary;
        this.yearOfExperience = yearOfExperience;
    }

    /**
     *
     */
    public EmployeeModel() {
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the employeeRole
     */
    public String getEmployeeRole() {
        return employeeRole;
    }

    /**
     * @param employeeRole the employeeRole to set
     */
    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the yearOfExperience
     */
    public long getYearOfExperience() {
        return yearOfExperience;
    }

    /**
     * @param yearOfExperience the yearOfExperience to set
     */
    public void setYearOfExperience(long yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }


}
