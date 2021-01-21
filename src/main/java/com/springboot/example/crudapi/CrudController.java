package com.springboot.example.crudapi;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class CrudController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrudController.class);

	@Autowired
	EmployeeRepository empRepo;
	
	@PostMapping("/create")
	public void createEmployee(@RequestBody Employee employee) {
		logger.info("New employee with id {} created", employee.getId());
		empRepo.save(employee);
	}
	
	@GetMapping("/get")
	public List<Employee> getAllEmployees() {
		logger.info("Get all employees list");
		return empRepo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Employee getSpecificEmployee(@PathVariable long id) {
		Optional<Employee> emp = empRepo.findById(id);

		if (!emp.isPresent()) {
			logger.error("Retrieve failed : No employee with id {} exists", id);
			throw new EmployeeNotFoundException();
		}

		logger.info("Get details of employee id {}", id);
		return emp.get();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable long id) {
		empRepo.deleteById(id);
		logger.info("Successfully deleted the employee of id {}", id);
	}
	
	@PutMapping("/update/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {

		Optional<Employee> empOptional = empRepo.findById(id);

		if (!empOptional.isPresent()) {
			logger.error("Update failed : No employee with id {} exists", id);
			throw new EmployeeNotFoundException();
		}

		employee.setId(id);
		
		empRepo.save(employee);
		logger.info("Update employee with id {}", id);
	}
	
	
	
	
}
