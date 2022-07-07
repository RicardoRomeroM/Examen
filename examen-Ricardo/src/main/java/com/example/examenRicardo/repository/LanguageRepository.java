package com.example.examenRicardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenRicardo.Model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
