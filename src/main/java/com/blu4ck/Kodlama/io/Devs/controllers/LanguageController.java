package com.blu4ck.Kodlama.io.Devs.controllers;

import com.blu4ck.Kodlama.io.Devs.models.Language;
import com.blu4ck.Kodlama.io.Devs.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = languageService.getAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable int id) {
        List<Language> languages = languageService.getById(id);
        if (languages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(languages.get(0), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addLanguage(@RequestBody Language language) {
        try {
            languageService.add(language);
            return new ResponseEntity<>("Language added successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable int id) {
        languageService.delete(id);
        return new ResponseEntity<>("Language deleted successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateLanguage(@RequestBody Language language) {
        try {
            languageService.update(language);
            return new ResponseEntity<>("Language updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
