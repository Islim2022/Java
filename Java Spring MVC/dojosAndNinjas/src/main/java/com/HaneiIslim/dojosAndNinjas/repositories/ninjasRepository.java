package com.HaneiIslim.dojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.dojosAndNinjas.models.Ninjas;

@Repository
public interface ninjasRepository extends CrudRepository<Ninjas, Long> {

    public List<Ninjas> findAll();

    public List<Ninjas> findByDescriptionContaining(String search);

}

