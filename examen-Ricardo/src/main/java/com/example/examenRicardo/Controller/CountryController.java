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

import com.example.examenRicardo.Model.Country;
import com.example.examenRicardo.exception.Mensaje;
import com.example.examenRicardo.servicios.CountryService;

@RestController
@RequestMapping("/Prueba3")
public class CountryController {
	
	@Autowired
	private CountryService countryservice;
	
	@GetMapping("/lista_pais")
	public ResponseEntity<?> getAllPais() {
		List<Country> lista = countryservice.getAllPais();
		
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin registros en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryservice.getAllPais());
	}


	@GetMapping("/pais_id/{id}")
	public ResponseEntity<Country> getPaisById(@PathVariable long id) {
		return ResponseEntity.ok().body(countryservice.getPaisById(id));
	
	}
	
	
	@PostMapping("/crearpais")
	public ResponseEntity<Country>createdPais(@RequestBody Country pais) {
		return ResponseEntity.ok().body(this.countryservice.createdPais(pais));
	}
	
	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<Country> updatePais(@PathVariable long id, @RequestBody Country pais) {
		pais.setId(id);
		return ResponseEntity.ok().body(this.countryservice.updatePais(pais));
	}

	
	@DeleteMapping("/Eliminar/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		this.countryservice.deleteCountry(id);
		return HttpStatus.OK;
	}
}
