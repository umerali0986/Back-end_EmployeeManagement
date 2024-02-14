package com.umercode.EmployeeManagement.Repository;

import com.umercode.EmployeeManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

        Optional<List<Employee>> findEmployeeByLastName(String firstName);
        Optional<List<Employee>> findByJobTitle(String jobTitle);
        Optional<Employee> findByEmployeeCode (String employeeCode);
        Optional<Employee> findByEmail (String email);
}
