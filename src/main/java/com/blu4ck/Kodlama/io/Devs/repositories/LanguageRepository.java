package com.blu4ck.Kodlama.io.Devs.repositories;

import com.blu4ck.Kodlama.io.Devs.models.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository {

    List<Language> getAll();

    List<Language> getById(int id);

    void add(Language language);

    void delete(int id);

    void update(Language language);

    boolean existByName(String name);
}
