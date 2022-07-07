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

import com.example.examenRicardo.Model.Language;
import com.example.examenRicardo.exception.Mensaje;
import com.example.examenRicardo.servicios.LanguageService;

@RestController
@RequestMapping("/Lenguaje")
public class LanguageController {
	
	@Autowired
	private LanguageService languageservice;
	
	@GetMapping("/lista_lenguajes")
	public ResponseEntity<?> getAllLanguage(){
		List<Language> lista = languageservice.getAllLanguage();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(languageservice.getAllLanguage());
	}
	
	@GetMapping("/language_id/{id}")
	public ResponseEntity<Language> getLanguageById(@PathVariable long id) {
		return ResponseEntity.ok().body(languageservice.getLanguageById(id));
	}
	
	@PostMapping("/crearemployee")
	public ResponseEntity<Language>createdLanguage(@RequestBody Language language) {
		return ResponseEntity.ok().body(this.languageservice.createdLanguage(language));
	}
	
	@PutMapping("/Actualizar_Lenguaje/{id}")
	public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language) {
		language.setId(id);
		return ResponseEntity.ok().body(this.languageservice.updateLanguage(language));
	}
	
	@DeleteMapping("/Eliminar/{id}")
	public HttpStatus deleteLanguage(@PathVariable long id) {
		this.languageservice.deleteLanguage(id);
		return HttpStatus.OK;
	}

}
