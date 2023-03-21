package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repositiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
	  Employee sar = new Employee();
//		sar.setFirstName("sarthak");
//		sar.setLastName("Sharma");
//		sar.setEmail("sar@gmail.com");
//        employeeRepository.save(sar);
//
//		Employee van = new Employee();
//		van.setFirstName("vansh");
//		van.setLastName("Sharma");
//		van.setEmail("vansh@gmail.com");
//		employeeRepository.save(van);
	}
}
