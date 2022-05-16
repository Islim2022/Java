package com.HaneiIslim.dojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.dojosAndNinjas.models.Dojos;

@Repository
public interface dojosRepository extends CrudRepository<Dojos, Long> {

    public List<Dojos> findAll();

    public List<Dojos> findByDescriptionContaining(String search);

}
