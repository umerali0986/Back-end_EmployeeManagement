package com.umercode.EmployeeManagement.Service;

import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Exceptions.UserAlreadyExistException;
import com.umercode.EmployeeManagement.Repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepo;

    private Employee john;
    private Employee johnMike;
    private Employee akil;
    @BeforeEach
    public void setUp(){
         john = new Employee(1l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));

         johnMike = new Employee(2l,"John","mike","johnmike@gmail.com","QA Developer","5439098712",
                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));

          akil = new Employee(3l,"Akil","Ahmed","akilahmed@gmail.com","Full-Stack Developer","7632178990",
                "https://bootdey.com/img,/content/avatar/avatar2.png", UUID.randomUUID().toString().substring(0,6));

    }
    @Test
    public void getAllEmployees_should_return_list_of_all_employees(){
        // Arrange

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(john, johnMike, akil));

        Mockito.when(employeeRepo.findAll()).thenReturn(employeeList);

        //Act
        List<Employee> actual = employeeService.getAllEmployees();

        //Assert
        assertFalse(actual.isEmpty());
        assertNotNull(actual);
        assertEquals(employeeList.size(),actual.size());
        assertEquals(employeeList.get(0).getEmail(),actual.get(0).getEmail());

        Mockito.verify(employeeRepo).findAll();
    }


    @Test
    public void getEmployeeById_should_return_employee_when_exist_employee_id_passed(){
        //Arrange
        Mockito.when(employeeRepo.findById(john.getId())).thenReturn(Optional.of(john));

        //Act
        Employee actual = employeeService.getEmployeeById(john.getId());

        //Assert
        assertNotNull(actual);
        assertEquals(john.getId(),actual.getId());

        Mockito.verify(employeeRepo).findById(john.getId());
    }

    @Test
    public void getEmployeeById_should_return_no_employee_when_nonExist_employee_id_passed(){
        //Arrange
        Long nonExistEmployeeId = 100l;
        Mockito.when(employeeRepo.findById(nonExistEmployeeId)).thenReturn(Optional.of(new Employee()));

        //Act
        Employee actual = employeeService.getEmployeeById(nonExistEmployeeId);

        //Assert
        assertNull(actual.getId()); // No employee With passed in ID number.

        Mockito.verify(employeeRepo).findById(nonExistEmployeeId);
    }


    @Test
    public void getEmployeeByName_should_return_employee_when_exist_employee_name_passed(){
        //Arrange
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        Mockito.when(employeeRepo.findByFirstName(john.getFirstName())).thenReturn(Optional.of(employeeList));

        //Act
        List<Employee> actual = employeeService.getEmployeeByName(john.getFirstName());

        //Assert
        assertNotNull(actual);
        assertEquals(1,actual.size());
        assertEquals(john.getId(),actual.get(0).getId());

        Mockito.verify(employeeRepo).findByFirstName(john.getFirstName());
    }


    @Test
    public void getEmployeeByName_should_return_empty_list_when_nonExist_employee_name_passed(){
        //Arrange
        String nonExistEmployeeName = "jujokan1";
        List<Employee> employeeList = new ArrayList<>();
        Mockito.when(employeeRepo.findByFirstName(nonExistEmployeeName)).thenReturn(Optional.of(employeeList));

        //Act
        List<Employee> actual = employeeService.getEmployeeByName(nonExistEmployeeName);

        //Assert
        assertEquals(0,actual.size()); // No employee With passed in name.

        Mockito.verify(employeeRepo).findByFirstName(nonExistEmployeeName);
    }

    @Test
    public void getEmployeeByCode_should_return_employee_when_exist_employee_code_passed(){
        //Arrange

        Mockito.when(employeeRepo.findByEmployeeCode(john.getEmployeeCode())).thenReturn(Optional.of(john));

        //Act
        Employee actual = employeeService.getEmployeeByCode(john.getEmployeeCode());

        //Assert
        assertNotNull(actual);
        assertEquals(john.getId(),actual.getId());

        Mockito.verify(employeeRepo).findByEmployeeCode(john.getEmployeeCode());
    }

    @Test
    public void getEmployeeByCode_should_return_no_employee_when_nonExist_employee_code_passed(){
        //Arrange
        String nonExistEmployeeCode = "------";
        Mockito.when(employeeRepo.findByEmployeeCode(nonExistEmployeeCode)).thenReturn(Optional.of(new Employee()));

        //Act
        Employee actual = employeeService.getEmployeeByCode(nonExistEmployeeCode);

        //Assert
        assertNull(actual.getId()); // No employee With passed in ID number.

        Mockito.verify(employeeRepo).findByEmployeeCode(nonExistEmployeeCode);
    }

    @Test
    public void getEmployeeByJobTitle_should_return_employee_when_exist_employee_jobTitle_passed(){
        //Arrange
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        Mockito.when(employeeRepo.findByJobTitle(john.getJobTitle())).thenReturn(Optional.of(employeeList));

        //Act
        List<Employee> actual = employeeService.getEmployeeByJobTitle(john.getJobTitle());

        //Assert
        assertNotNull(actual);
        assertEquals(john.getId(),actual.get(0).getId());

        Mockito.verify(employeeRepo).findByJobTitle(john.getJobTitle());
    }


    @Test
    public void getEmployeeByJobTitle_should_return_empty_list_when_nonExist_employee_jobTitle_passed(){
        //Arrange
        String nonExistEmployeeJobTitle = "jujokan1";
        List<Employee> employeeList = new ArrayList<>();
        Mockito.when(employeeRepo.findByJobTitle(nonExistEmployeeJobTitle)).thenReturn(Optional.of(employeeList));

        //Act
        List<Employee> actual = employeeService.getEmployeeByJobTitle(nonExistEmployeeJobTitle);

        //Assert
        assertEquals(0,actual.size()); // No employee With passed in name.

        Mockito.verify(employeeRepo).findByJobTitle(nonExistEmployeeJobTitle);
    }


    @Test
    public void createEmployee_should_return_employee_when_new_employee_passed(){
        //Arrange
        String email = UUID.randomUUID().toString().substring(0,7) + "@gmail.com";
        Employee newEmployee = new Employee(1l,"Alex","Yan",email,"Back-end Developer","5439082312",
                "https://bootdey.com/img,/content/avatar/avatar1.png", null);

        Mockito.when(employeeRepo.save(newEmployee)).thenReturn(newEmployee);

        //Act
        Employee actual = employeeService.createEmployee(newEmployee);
        newEmployee.setEmployeeCode(actual.getEmployeeCode());

        //Assert
        assertNotNull(actual);
        assertEquals(newEmployee.getEmail(),actual.getEmail());
        assertEquals(newEmployee.getEmployeeCode(),actual.getEmployeeCode());


        newEmployee.setEmployeeCode(null); // set newEmployee code to null to verify that mock method is getting invoked with the right argument.
        Mockito.verify(employeeRepo).save(newEmployee);

        Mockito.verify(employeeRepo).findByEmail(newEmployee.getEmail());
    }


    @Test
    public void updateEmployee_should_return_updated_employee_when_exist_employee_passed(){
        //Arrange
        String employeeCode = UUID.randomUUID().toString().substring(0,6);

        Employee beforeUpdateEmployee = new Employee(1l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
                "https://bootdey.com/img,/content/avatar/avatar1.png", employeeCode);

        Employee afterUpdateEmployee = new Employee(1l,"John","Smith","johnsmith@gmail.com","QA Developer","5439098712",
                "https://bootdey.com/img,/content/avatar/avatar2.png", employeeCode);

        Mockito.when(employeeRepo.findById(beforeUpdateEmployee.getId())).thenReturn(Optional.of(beforeUpdateEmployee));

        //Act
        Employee actual = employeeService.updateEmployee(beforeUpdateEmployee.getId(), afterUpdateEmployee);

        // Assert
        assertEquals(afterUpdateEmployee.getId(),actual.getId());
        assertEquals(afterUpdateEmployee.getEmail(),actual.getEmail());
        assertEquals(afterUpdateEmployee.getJobTitle(),actual.getJobTitle());

        Mockito.verify(employeeRepo).findById(beforeUpdateEmployee.getId());

    }

    @Test
    public void deleteEmployeeById_should_delete_exist_Employee(){
        //Arrange
            Mockito.when(employeeRepo.findById(john.getId())).thenReturn(Optional.of(john));

        //Act
        employeeService.deleteEmployeeById(john.getId());

        //Assert
        Mockito.verify(employeeRepo).findById(john.getId());
    }

}