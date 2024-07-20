package com.blu4ck.Kodlama.io.Devs.services;

import com.blu4ck.Kodlama.io.Devs.models.Language;
import com.blu4ck.Kodlama.io.Devs.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService implements LanguageRepository {
    private final List<Language> languages = new ArrayList<>();

    @Override
    public List<Language> getAll() {
        return new ArrayList<>(languages);
    }

    @Override
    public List<Language> getById(int id) {
        List<Language> result = new ArrayList<>();
        for (Language language : languages) {
            if (language.getId() == id) {
                result.add(language);
            }
        }
        return result;
    }

    @Override
    public void add(Language language) {
        if (language.getName() == null || language.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (existByName(language.getName())) {
            throw new IllegalArgumentException("Name already exists: " + language.getName());
        }
        languages.add(language);
    }

    @Override
    public void delete(int id) {
        languages.removeIf(language -> language.getId() == id);
    }

    @Override
    public void update(Language language) {
        if (language.getName() == null || language.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        delete(language.getId());
        languages.add(language);
    }

    @Override
    public boolean existByName(String name) {
        return languages.stream().anyMatch(language -> language.getName().equals(name));
    }
}
