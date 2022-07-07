package com.example.examenRicardo.servicios;
import java.util.List;
import com.example.examenRicardo.Model.Employee;

public interface EmployeeService {
	
	Employee createdEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(long employeeId);
	
	void deleteEmployee (long id);
	
}
