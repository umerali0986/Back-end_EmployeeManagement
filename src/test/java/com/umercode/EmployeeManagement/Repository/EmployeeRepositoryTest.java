package com.umercode.EmployeeManagement.Repository;

import com.umercode.EmployeeManagement.Entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.datasource.url = jdbc:h2://mem:db;DB_DELAY_CLOSE=-1",
        "spring.datasource.username = sa",
        "spring.datasource.password = sa",
        "spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.H2Dialect",
})
@TestMethodOrder(MethodOrderer.MethodName.class)

public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepo;

    private Employee john;
    private Employee johnMike;
    private Employee akil;


    @BeforeEach//TODO- setup a data only once before test run.(i.e Use @BeforeAll)
    @DirtiesContext
    public void setUp(){
         john = new Employee(1l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));

         johnMike = new Employee(2l,"John","mike","johnmike@gmail.com","QA Developer","5439098712",
                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));

         akil = new Employee(3l,"Akil","Ahmed","akilahmed@gmail.com","Full-Stack Developer","7632178990",
                "https://bootdey.com/img,/content/avatar/avatar2.png", UUID.randomUUID().toString().substring(0,6));

        employeeRepo.saveAll(Arrays.asList(john,johnMike,akil));
    }

    @AfterEach
    public void tearUp(){
        employeeRepo.deleteAll();
    }

    @Test
    @DirtiesContext
    public void findByFirstName_should_return_list_of_employees_when_exist_employee_name_passed(){

        //Act
        Optional<List<Employee>> actual = employeeRepo.findByFirstName("John");

        //Assert
        assertTrue(actual.isPresent());
        assertNotNull(actual.get());
        assertEquals(2,actual.get().size());


    }

    @Test
    public void findByFirstName_should_return_empty_list_when_nonExist_employee_name_passed(){

        //Arrange
        String nonExistName = "ajoaj43";

        //Act
        Optional<List<Employee>> actual = employeeRepo.findByFirstName(nonExistName);

        //Assert
        assertEquals(0,actual.get().size());
        assertNotNull(actual.get());
    }


    @Test
    public void findByJobTitle_should_return_list_of_employees_when_exist_employee_jobTitle_passed(){

        //Act
        Optional<List<Employee>> actual = employeeRepo.findByJobTitle(john.getJobTitle());

        //Assert
        assertTrue(actual.isPresent());
        assertNotNull(actual.get());
        assertEquals(1,actual.get().size());
        assertEquals(john.getEmail(),actual.get().get(0).getEmail());


    }

    @Test
    public void findByJobTitle_should_return_empty_list_when_nonExist_employee_jobTitle_passed(){
        //Arrange
        String nonExistJobTitle = "ajoaj43";

        //Act
        Optional<List<Employee>> actual = employeeRepo.findByJobTitle(nonExistJobTitle);

        //Assert
        assertEquals(0,actual.get().size());
        assertNotNull(actual.get());
    }


    @Test
    public void findByEmployeeCode_should_return_employee_when_exist_employee_code_passed(){

        //Act
        Optional<Employee> actual = employeeRepo.findByEmployeeCode(john.getEmployeeCode());

        //Assert
        assertTrue(actual.isPresent());
        assertNotNull(actual.get());
        assertEquals(john.getEmail(),actual.get().getEmail());

    }


    @Test
    public void findByEmployeeCode_should_return_empty_when_nonExist_employee_code_passed(){

        String nonExistEmployeeCode = "177756";
        //Act
        Optional<Employee> actual = employeeRepo.findByEmployeeCode(nonExistEmployeeCode);

        //Assert
        assertTrue(actual.isEmpty());

    }

    @Test
    public void findByEmail_should_return_employee_when_exist_employee_email_passed(){

        //Act
        Optional<Employee> actual = employeeRepo.findByEmail(john.getEmail());

        //Assert
        assertTrue(actual.isPresent());
        assertNotNull(actual.get());
        assertEquals(john.getEmail(),actual.get().getEmail());

    }


    @Test
    public void findByEmail_should_return_empty_when_nonExist_employee_email_passed(){

        String nonExistEmail = "9992940ua@gmail.com";
        //Act
        Optional<Employee> actual = employeeRepo.findByEmployeeCode(nonExistEmail);

        //Assert
        assertTrue(actual.isEmpty());

    }
}