package com.umercode.EmployeeManagement;

import com.umercode.EmployeeManagement.Entity.Employee;
import com.umercode.EmployeeManagement.Repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
//		return args->{
//			Employee john = new Employee(null,"John","Smith","johnsmith@gmail.com","Back-end Developer","5439082312",
//					"https://bootdey.com/img,/content/avatar/avatar1.png", UUID.randomUUID().toString().substring(0,6));
//
//			Employee akil = new Employee(null,"Akil","Ahmed","akilahmed@gmail.com","Full-Stack Developer","7632178990",
//					"https://bootdey.com/img,/content/avatar/avatar2.png", UUID.randomUUID().toString().substring(0,6));
//
//			employeeRepository.saveAll(Arrays.asList(john,akil));
//		};
//	}

}
