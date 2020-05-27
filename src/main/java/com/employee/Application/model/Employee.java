package com.employee.Application.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    private int employeeID;

    @NotNull
    @Column(name= "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee(){

    }

    public Employee(String firstname, String lastname, @NotNull Department department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
