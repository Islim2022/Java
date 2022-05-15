package com.HaneiIslim.Languages.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.Languages.models.language;

@Repository
public interface languageRepository extends CrudRepository<language, Long> {

    public List<language> findAll();

    public List<language> findByDescriptionContaining(String search);

}