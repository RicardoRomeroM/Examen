package com.example.examenRicardo.servicios;

import java.util.List;

import com.example.examenRicardo.Model.Country;

public interface CountryService {
	Country createdPais(Country pais);
	
	Country updatePais(Country pais);
	
	List<Country> getAllPais();
	
	Country getPaisById(long paisId);
	
	void deleteCountry (long id);	

}
