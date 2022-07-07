package com.example.examenRicardo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.examenRicardo.Model.Country;
import com.example.examenRicardo.exception.ResourceNotFoundException;
import com.example.examenRicardo.repository.CountryRepository;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public Country createdPais(Country pais) {
		return countryRepository.save(pais);
	}
	
	@Override
	public Country updatePais(Country pais) {
		Optional<Country> countryDb = this.countryRepository.findById(pais.getId());
		if(countryDb.isPresent()) {
			Country paisUpdate = countryDb.get();
			paisUpdate.setId(pais.getId());
			paisUpdate.setName(pais.getName());
			paisUpdate.setCode(pais.getCode());
			countryRepository.save(paisUpdate);
			return paisUpdate;			
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + pais.getId());
		}
	}
	
	@Override
	public List<Country> getAllPais(){
		return this.countryRepository.findAll();
	}
	
	@Override
	public Country getPaisById(long paisId) {
		Optional<Country> countryDb = this.countryRepository.findById(paisId);
		if (countryDb.isPresent()){
			return countryDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + paisId);
		}	
	}
	@Override
	public void deleteCountry (long paisId) {
		Optional<Country> countryDb = this.countryRepository.findById(paisId);
		
		if (countryDb.isPresent()) {
			this.countryRepository.delete(countryDb.get());	
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + paisId);
		}
	}

}
