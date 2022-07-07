package com.example.examenRicardo.servicios;

import java.util.List;

import com.example.examenRicardo.Model.Language;

public interface LanguageService {
	
	Language createdLanguage(Language language);
	
	Language updateLanguage(Language language);
	
	List<Language> getAllLanguage();
	
	Language getLanguageById(long languageId);
	
	void deleteLanguage (long id);	

}
