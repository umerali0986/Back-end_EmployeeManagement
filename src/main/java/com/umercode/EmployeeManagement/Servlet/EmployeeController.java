package com.umercode.EmployeeManagement.Servlet;

import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeServiceImpl employeeService;

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    //TODO-It's not retrieving employee by name, fix it
    @GetMapping(path = "/name/{employeeName}")
    public List<Employee> getEmployeeByName(@PathVariable("employeeName") String employeeName){
        return employeeService.getEmployeeByName(employeeName);
    }

    @GetMapping(path = "/jobTitle/{jobtitle}")
    public List<Employee> getEmployeeByJobTitle(@PathVariable("jobtitle") String jobTitle){
        return employeeService.getEmployeeByJobTitle(jobTitle);
    }

    @GetMapping(path = "/code/{employeeCode}")
    public Employee getEmployeeByEmployeeCode(@PathVariable("employeeCode") String employeeCode){
        return employeeService.getEmployeeByEmployeeCode(employeeCode);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping(path = "/update/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping(path ="/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }
}
