package com.example.examenRicardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenRicardo.Model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
