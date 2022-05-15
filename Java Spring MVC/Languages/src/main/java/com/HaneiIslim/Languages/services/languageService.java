package com.HaneiIslim.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HaneiIslim.Languages.models.language;
import com.HaneiIslim.Languages.repositories.languageRepository;

@Service 
public class languageService {
    // adding the Language repository as a dependency
    private final languageRepository languageRepo;
    
    public languageService(languageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }
    
    // returns all the Languages
    public List<language> allLanguages() {
        return languageRepo.findAll();
    }
    // creates a Language
    public language createLanguage(language lang) {
        return languageRepo.save(lang);
    }
    // retrieves a Language
    public language findLanguage(Long id) {
        Optional<language> optionalLanguage = languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public language updateLanguage(language lang) {
    	Optional<language> optionalLanguage = languageRepo.findById(lang.getId());
        if(optionalLanguage.isPresent()) {
        	language language = optionalLanguage.get();
        	language.setName(lang.getName());
        	language.setCreator(lang.getCreator());
        	language.setVersion(lang.getVersion());
        	languageRepo.save(language);
            return language;
        } else {
            return null;
        }
    }
    
    public void deleteLanguage(Long id) {
    	languageRepo.deleteById(id);
    }

}
