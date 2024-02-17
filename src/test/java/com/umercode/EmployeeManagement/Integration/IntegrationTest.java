package com.umercode.EmployeeManagement.Integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Repository.EmployeeRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class IntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private EmployeeRepository employeeRepo;
//    @Autowired
//    private ObjectMapper objectMapper;
//
////    private Employee john;
////    private Employee johnMike;
////    private Employee akil;
//
//
//
////    @BeforeEach
////    public  void setUp(){
////       Employee john = new Employee(null,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
////                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));
////
////       Employee johnMike = new Employee(null,"John","mike","johnmike@gmail.com","QA Developer","5439098712",
////                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));
////
////      Employee  akil = new Employee(null,"Akil","Ahmed","akilahmed@gmail.com","Full-Stack Developer","7632178990",
////                "https://bootdey.com/img,/content/avatar/avatar2.png", UUID.randomUUID().toString().substring(0,6));
////
////       employeeRepo.save(john);
////       employeeRepo.save(johnMike);
////       employeeRepo.save(akil);
////
////    }
////
////    @AfterEach
////    public  void tearUp(){
////        employeeRepo.deleteAll();
////    }
//
//    @Test
//    @DirtiesContext
//    public void it_should_get_all_employees() throws Exception {
//
//        //Act
//       mockMvc.perform(get("/employee/all"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").exists());
//        assert(!employeeRepo.findAll().isEmpty());
//        employeeRepo.deleteAll();
//    }
//
//    @Test
//    public void it_should_get_employee_by_id() throws Exception {
//        //Arrange
//        Employee john = new Employee(33l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
//                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));
//        //Act
//        mockMvc.perform(get("/employee/{id}",1))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath(".firstName").value("John"));
//    }
//
//    @Test
//    public void it_should_get_employee_by_name() throws Exception {
//        //Arrange
//        Employee john = new Employee(33l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
//                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));
//        //Act
//        mockMvc.perform(get("/employee/name/{employeeName}",john.getFirstName()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath(".firstName").value("John"));
//    }
//
//
//    @Test
//    public void it_should_get_employee_by_jobTitle() throws Exception {
//        //Arrange
//        Employee john = new Employee(33l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
//                "https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));
//        //Act
//        mockMvc.perform(get("/employee/jobTitle/{jobTitle}",john.getJobTitle()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath(".jobTitle").value(john.getJobTitle()));
//    }
//
//
//    @Test
//    public void it_should_get_employee_by_employeeCode() throws Exception {
//        //Arrange
//        Employee john = new Employee(33l,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
//                "https://bootdey.com/img,/content/avatar/avatar1.png", "uj83aw");
//        //Act
//        mockMvc.perform(get("/employee/code/{employeeCode}",john.getEmployeeCode()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.employeeCode").value(john.getEmployeeCode()));
//    }
//
//    @Test
//    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//
//    public void it_should_create_new_employee() throws Exception {
//        //Arrange
//        Employee leo = new Employee(4l,"Leo","Sam","leosam@gmail.com","Back-end Developer","5439082312",
//                "https://bootdey.com/img,/content/avatar/avatar2.png", "ui98yb");
//
//        //Act
//        mockMvc.perform(post("/employee/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(leo)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath(".id").isNotEmpty());
//    }
}
