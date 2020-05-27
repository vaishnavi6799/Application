package com.employee.Application.services;

import com.employee.Application.model.Department;
import com.employee.Application.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // fetching all department
    public List<Department> getAllDepartments(){
        List<Department> depts = (List<Department>)departmentRepository.findAll();
        return depts;
    }

    // fetching department by id
    public Department getDepartment(int id){

        return (Department) departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department Id : " + id));
    }

    // inserting department
    public void addDepartment(Department d) {

        departmentRepository.save(d);
    }

    // updating department by id
    public void editDepartment(int id, Model model){
        Department dept = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department Id : " + id));

        model.addAttribute("department", dept);
    }
    public void updateDepartment(int id, Department dept,Model model){
        //System.out.println("department "+dept.getDepartment_ID()+dept.getCode_Name()+dept.getDepartment_Name());
            departmentRepository.save(dept);

        model.addAttribute("department",departmentRepository.findAll());
    }

    // deleting all departments
    public void deleteAllDepartment(){
        departmentRepository.deleteAll();
    }

    // deleting department by id
    public void deleteDepartmentByID(int id){

        Department dept = this.departmentRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Invalid Department id : " + id));
        departmentRepository.delete(dept);
        //departmentRepository.deleteById(id);
    }



}
