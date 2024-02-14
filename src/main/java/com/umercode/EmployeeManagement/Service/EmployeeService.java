package com.umercode.EmployeeManagement.Service;

import com.umercode.EmployeeManagement.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByJobTitle(String jobTitle);
    Employee getEmployeeByEmployeeCode(String employeeCode);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployeeById(Long id);


}
