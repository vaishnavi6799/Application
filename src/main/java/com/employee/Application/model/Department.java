package com.employee.Application.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int department_ID;

    @Size(min=2, max=10)
    @NotNull
    private String code_Name;

    @Size(min=2, max=100)
    @NotNull
    private String department_Name;

    public Department() {
    }

    public Department(int department_ID, String code_Name, String department_Name) {
        this.department_ID = department_ID;
        this.code_Name = code_Name;
        this.department_Name = department_Name;
    }

    public Department(int department_ID) {
        this.department_ID = department_ID;
    }

    public int getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        this.department_ID = department_ID;
    }

    public String getCode_Name() {
        return code_Name;
    }

    public void setCode_Name(String code_Name) {
        this.code_Name = code_Name;
    }

    public String getDepartment_Name() {
        return department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        this.department_Name = department_Name;
    }
}
