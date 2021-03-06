package com.HaneiIslim.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HaneiIslim.dojosAndNinjas.models.Dojos;
import com.HaneiIslim.dojosAndNinjas.models.Ninjas;
import com.HaneiIslim.dojosAndNinjas.repositories.dojosRepository;
import com.HaneiIslim.dojosAndNinjas.repositories.ninjasRepository;

@Service 
public class dojosAndNinjasService {
    // adding the Ninjas repository as a dependency
    private final ninjasRepository ninjasRepo;
    
    public dojosAndNinjasService(ninjasRepository ninjasRepo) {
        this.ninjasRepo = ninjasRepo;
		this.dojosRepo = null;
    }
    
    // adding the Dojos repository as a dependency
    private final dojosRepository dojosRepo;
    
    public dojosAndNinjasService(dojosRepository dojosRepo) {
        this.ninjasRepo = null;
		this.dojosRepo = dojosRepo;
    }
    
    // returns all the Ninjas
    public List<Ninjas> allNinjas() {
        return ninjasRepo.findAll();
    }
    
    // creates a Ninja
    public Ninjas createNinja(Ninjas ninja) {
        return ninjasRepo.save(ninja);
    }
    // retrieves a Ninja
    public Ninjas findNinja(Long id) {
        Optional<Ninjas> optionalNinja = ninjasRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    // returns all the Dojos
    public List<Dojos> allDojos() {
        return dojosRepo.findAll();
    }
    
    // creates a Dojo
    public Dojos createDojo(Dojos dojo) {
        return dojosRepo.save(dojo);
    }
    // retrieves a Dojo
    public Dojos findDojo(Long id) {
        Optional<Dojos> optionalDojo = dojosRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
    
//    public Ninjas updateNinja(Ninjas ninja) {
//    	Optional<Ninjas> optionalNinja = dojosAndNinjasRepo.findById(ninja.getId());
//        if(optionalNinja.isPresent()) {
//        	Ninjas n = optionalNinja.get();
//        	n.setFirstName(ninja.getFirstName());
//        	n.setLastName(ninja.getLastName());
//        	n.setAge(ninja.getAge());
//        	dojosAndNinjasRepo.save(n);
//            return n;
//        } else {
//            return null;
//        }
//    }
    
//    public void deleteNinja(Long id) {
//    	dojosAndNinjasRepo.deleteById(id);
//    }
//
//}
