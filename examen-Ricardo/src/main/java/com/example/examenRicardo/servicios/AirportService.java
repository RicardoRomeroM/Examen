package com.example.examenRicardo.servicios;

import java.util.List;

import com.example.examenRicardo.Model.Airport;

public interface AirportService {
	
	Airport createdAirport(Airport airport);
	
	Airport updateAirport(Airport airport);
	
	List<Airport> getAllAirport();
	
	Airport getAirportById(long airportId);
	
	void deleteAirport(long id);

}
