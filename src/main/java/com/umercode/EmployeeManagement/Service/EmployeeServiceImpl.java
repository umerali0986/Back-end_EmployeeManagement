package com.umercode.EmployeeManagement.Service;

import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id){
        if(employeeRepository.findById(id).isEmpty()){
            new Employee();
        }
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        if (employeeRepository.findByEmployeeCode(name).isEmpty()){
            return new ArrayList<>();
        }
        return employeeRepository.findEmployeeByLastName(name).get();
    }

    @Override
    public List<Employee> getEmployeeByJobTitle(String jobTitle) {
        if(employeeRepository.findByJobTitle(jobTitle).isEmpty()){
            return new ArrayList<>();
        }
        return employeeRepository.findByJobTitle(jobTitle).get();
    }

    @Override
    public Employee getEmployeeByEmployeeCode(String employeeCode) {
        if(employeeRepository.findByEmployeeCode(employeeCode).isEmpty()){
            return new Employee();
        }
        return employeeRepository.findByEmployeeCode(employeeCode).get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
      try{
          if(employeeRepository.findByEmployeeCode(employee.getEmployeeCode()).isPresent()){
              throw new IllegalStateException("Employee already exist.");
          }

          if(employeeRepository.findByEmail(employee.getEmail()).isPresent()){
            throw new IllegalStateException("Email is taken.");
          }
      }catch (IllegalStateException e){
          System.out.println(e.getMessage());
          return null;
      }
        employee.setEmployeeCode(UUID.randomUUID().toString().substring(0,6));
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
       try {
           if(employeeRepository.findById(id).isEmpty()){
               throw new IllegalStateException("Employee doesn't exist");
           }
       }catch (IllegalStateException e){
           System.out.println(e.getMessage());
           return null;
       }
        Employee employeeFromDB = employeeRepository.findById(id).get();

        employeeFromDB.setImageUrl(employee.getImageUrl());
        employeeFromDB.setPhone(employee.getPhone());
        employeeFromDB.setJobTitle(employee.getJobTitle());
        employeeFromDB.setEmail(employee.getEmail());
        return employeeFromDB;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
