package com.employee.Application.services;

import com.employee.Application.model.Department;
import com.employee.Application.model.Employee;
import com.employee.Application.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // fetching all employees
    public List<Employee> getAllEmployees(){
        List<Employee> emps = (List<Employee>)employeeRepository.findAll();
        return emps;
    }

    // fetching employee by id
    public Employee getEmployee(int id){
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id : " + id));
    }

    // inserting employee
    public void addEmployee(Employee e) {
        employeeRepository.save(e);
    }

    // updating employee by id
    public void updateEmployee(int id,Employee emp,Model model){
        employeeRepository.save(emp);
        model.addAttribute("employee",employeeRepository.findAll());
    }

    public void editEmployee(int id, Model model) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id : " + id));
        model.addAttribute("employee", emp);
    }

    // deleting all employees
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    // deleting employee by id
    public void deleteEmployeeByID(int id){
        Employee emp = this.employeeRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Invalid Employee id : " + id));
      employeeRepository.delete(emp);
    }


    public List<Employee> groupByDeptartmentID(int id) {
        List<Employee> emps  = (List<Employee>)employeeRepository.findAll();
        List<Employee> employees = emps.stream()
                .filter(e ->e.getDepartment().getDepartment_ID() == id)
                .collect(Collectors.toList());
        return employees;
    }
}
