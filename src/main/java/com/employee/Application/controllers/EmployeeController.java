package com.employee.Application.controllers;

import com.employee.Application.model.Department;
import com.employee.Application.model.Employee;
import com.employee.Application.services.DepartmentService;
import com.employee.Application.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Async
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    // displaying list of all employees
    @GetMapping("/employees")
    public String getAllEmployee(Model model){
        model.addAttribute("employee", employeeService.getAllEmployees());
        model.addAttribute("department", departmentService.getAllDepartments());

        return "list_employees";
    }

    // displaying employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    // inserting employee
    @RequestMapping(value = "/add_employee",method = RequestMethod.GET)
    public ModelAndView showEmployeeForm(Model model){
        System.out.println("Employee form page");
        model.addAttribute("department", departmentService.getAllDepartments());
        return new ModelAndView("add_employee", "employee", new Employee());

    }
    @PostMapping("/add_employees")
    public String addEmployees(@Valid @ModelAttribute("employee")Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
           return "add_employee";
        }

        employeeService.addEmployee(employee);
        return "index";
    }

    //updating employee by id

    @PostMapping("update_employee/{id}")
    public String updateEmployee(@PathVariable("id") int id, @Valid Employee emp, BindingResult result, Model model){
        if(result.hasErrors()){
            emp.setEmployeeID(id);
            return "update_employee";
        }

        employeeService.updateEmployee(id,emp,model);
        return "index";
    }
    @GetMapping("edit_employee/{id}")
    public String showEmpUpdateForm(@PathVariable("id") int id,Model model){
        model.addAttribute("department", departmentService.getAllDepartments());
        employeeService.editEmployee(id,model);
        return "update_employee";
    }


    // deleting all employees
    @GetMapping("/delete_allemployees")
    public String deleteAllEmployees(){
        employeeService.deleteAllEmployees();
        return "index" ;
    }

    // deleting employee by id
    @GetMapping("/delete_employee/{id}")
    public String deleteEmployeeByID(@PathVariable("id") int id,Model model){
        employeeService.deleteEmployeeByID(id);
        model.addAttribute("employee",employeeService.getAllEmployees());
        return "index";
    }
    //Group employees according to department
    @GetMapping("/group_employees/{id}")
    public String groupEmployees(@PathVariable("id") int id,Model model){
        model.addAttribute("d_employees", employeeService.groupByDeptartmentID(id));
        return "group_employees";
    }
}

