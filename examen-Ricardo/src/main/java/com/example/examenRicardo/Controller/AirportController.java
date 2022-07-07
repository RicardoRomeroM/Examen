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

import com.example.examenRicardo.Model.Airport;
import com.example.examenRicardo.exception.Mensaje;
import com.example.examenRicardo.servicios.AirportService;


@RestController
@RequestMapping("/Prueba1")
public class AirportController {
	
	@Autowired
	private	AirportService airportservice;
	
	@GetMapping("/lista_airport")
	public ResponseEntity<?> getAllAirport() {
		List<Airport> lista = airportservice.getAllAirport();
		
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(airportservice.getAllAirport());
	}


	@GetMapping("/airport_id/{id}")
	public ResponseEntity<Airport> getAirportById(@PathVariable long id) {
		return ResponseEntity.ok().body(airportservice.getAirportById(id));
	
	}
	
	@PostMapping("/crearAirport")
	public ResponseEntity<Airport>createdAirport(@RequestBody Airport airport) {
		return ResponseEntity.ok().body(this.airportservice.createdAirport(airport));
	}
	
	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
		airport.setId(id);
		return ResponseEntity.ok().body(this.airportservice.updateAirport(airport));
	}
	
	@DeleteMapping("/Eliminar/{id}")
	public HttpStatus deleteAirport(@PathVariable long id) {
		this.airportservice.deleteAirport(id);
		return HttpStatus.OK;
	}

}
