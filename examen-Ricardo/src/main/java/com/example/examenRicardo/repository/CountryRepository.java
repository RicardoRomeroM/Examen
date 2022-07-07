package com.example.examenRicardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.examenRicardo.Model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
