package com.umercode.EmployeeManagement.Service;

import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Exceptions.UserAlreadyExistException;
import com.umercode.EmployeeManagement.Exceptions.UserNotFoundException;
import com.umercode.EmployeeManagement.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByFirstName(name).get();
    }

    @Override
    public List<Employee> getEmployeeByJobTitle(String jobTitle) {
        return employeeRepository.findByJobTitle(jobTitle).get();
    }

    @Override
    public Employee getEmployeeByCode(String employeeCode) {
      Optional<Employee> employee = employeeRepository.findByEmployeeCode(employeeCode);
        return employee.orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
      try{
          if(employeeRepository.findByEmail(employee.getEmail()).isPresent()){
            throw new UserAlreadyExistException("email");
          }
      }catch (UserAlreadyExistException e){
          System.out.println(e.getMessage());
          return null;
      }
        employee.setEmployeeCode(UUID.randomUUID().toString().substring(0,6));
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Optional<Employee> employeeFromDB = employeeRepository.findById(id);

        try {
           if(employeeFromDB.isEmpty()){
               throw new UserNotFoundException("Employee doesn't exist");
           }
       }catch (UserNotFoundException e){
           System.out.println(e.getMessage());
           return null;
       }

        employeeFromDB.get().setImageUrl(employee.getImageUrl());
        employeeFromDB.get().setPhone(employee.getPhone());
        employeeFromDB.get().setJobTitle(employee.getJobTitle());
        employeeFromDB.get().setEmail(employee.getEmail());

        return employeeFromDB.get();
    }

    @Override //TODO- Archieved a data instead of deleting from a table
    public void deleteEmployeeById(Long id) {
        try {
            if(employeeRepository.findById(id).isEmpty()){
                throw new UserNotFoundException("Employee doesn't exist");
            }
        }catch(UserNotFoundException e){
            System.out.println(e.getMessage());
        }
        employeeRepository.deleteById(id);
    }
}
