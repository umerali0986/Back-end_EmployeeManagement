package com.umercode.EmployeeManagement.Servlet;

import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeServiceImpl employeeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }


    @GetMapping(path = "/name/{employeeName}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("employeeName") String employeeName){
        return new ResponseEntity<>(employeeService.getEmployeeByName(employeeName),HttpStatus.OK);
    }

    @GetMapping(path = "/jobTitle/{jobtitle}")
    public ResponseEntity<List<Employee>> getEmployeeByJobTitle(@PathVariable("jobtitle") String jobTitle){
        return new ResponseEntity<>(employeeService.getEmployeeByJobTitle(jobTitle),HttpStatus.OK);
    }

    @GetMapping(path = "/code/{employeeCode}")
    public ResponseEntity<Employee> getEmployeeByEmployeeCode(@PathVariable("employeeCode") String employeeCode){
        return new ResponseEntity<>(employeeService.getEmployeeByCode(employeeCode),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(id,employee),HttpStatus.OK);
    }

    @DeleteMapping(path ="/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }
}
