package com.example.examenRicardo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenRicardo.Model.Employee;
import com.example.examenRicardo.exception.Mensaje;
import com.example.examenRicardo.servicios.EmployeeService;



@RestController
@RequestMapping("/Prueba")
public class EmployeeController {
	
	@Autowired
	private	EmployeeService employeeservice;

	
	@GetMapping("/lista_employee")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> lista = employeeservice.getAllEmployee();
		
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeeservice.getAllEmployee());
	}


	@GetMapping("/employed_id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeservice.getEmployeeById(id));
	
	}
	
	
	@PostMapping("/crearemployee")
	public ResponseEntity<Employee>createdEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.employeeservice.createdEmployee(employee));
	}
	


	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeservice.updateEmployee(employee));
	}

	
	@DeleteMapping("/Eliminar/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		this.employeeservice.deleteEmployee(id);
		return HttpStatus.OK;
	}
}