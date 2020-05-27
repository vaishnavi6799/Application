package com.employee.Application.controllers;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import com.employee.Application.model.Department;
import com.employee.Application.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }
    // displaying list of all department
    @GetMapping("/departments")
    public String getAllDepartment(Model model){
        model.addAttribute("department", departmentService.getAllDepartments());
        return "list_departments";
    }

    // displaying department by id
    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable int id){

        return departmentService.getDepartment(id);
    }

    // inserting department
    @RequestMapping(value = "/add_department",method = RequestMethod.GET)
    public ModelAndView showDepartmentForm(){
        System.out.println("Department form page");
        return new ModelAndView("add_department", "department", new Department());

    }
    @PostMapping("/add_departments")
    public String addDepartment(@Valid @ModelAttribute("department")Department department, BindingResult result){
        if(result.hasErrors()){
            return "add_department";
        }
        departmentService.addDepartment(department);
        return "index";
    }

    //updating department by id

    @PostMapping("update_department/{id}")
    public String updateStudent(@PathVariable("id") int id, @Valid Department dept, BindingResult result, Model model){
        if(result.hasErrors()){
            dept.setDepartment_ID(id);
            return "update_department";
        }
        departmentService.updateDepartment(id,dept,model);
        return "index";
    }
    @GetMapping("edit_department/{id}")
    public String showDeptUpdateForm(@PathVariable("id") int id,Model model){
        departmentService.editDepartment(id,model);
        return "update_department";
    }

    // deleting all departments
    @GetMapping("/delete_alldepartments")
    public String deleteAllDepartments(){
        departmentService.deleteAllDepartment();
        return "index";
    }

    // deleting department by id
    @GetMapping("delete_departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") int id,Model model){
        departmentService.deleteDepartmentByID(id);
        model.addAttribute("students",departmentService.getAllDepartments());
        return "index";
    }



}
