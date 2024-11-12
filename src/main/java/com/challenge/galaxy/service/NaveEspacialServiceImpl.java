package com.challenge.galaxy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.challenge.galaxy.model.NaveEspacial;
import com.challenge.galaxy.repository.NaveEspacialRepository;

@Service
public class NaveEspacialServiceImpl implements NaveEspacialService{

	@Autowired
	private NaveEspacialRepository naveEspacialRepository;

	@Override
	public Page<NaveEspacial> getAllNaves(int page, int size) {
		return naveEspacialRepository.findAll(PageRequest.of(page, size));
		
	}

	@Override
	public Optional<NaveEspacial> getNaveById(Long id) {
		return naveEspacialRepository.findById(id);
	}
	
	@Override
	public List<NaveEspacial> getNavesByNombre(String nombre) {
		return naveEspacialRepository.findByNombreContainingIgnoreCase(nombre);
	}
	
	   public NaveEspacial createNave(NaveEspacial naveEspacial) {
	        return naveEspacialRepository.save(naveEspacial);
	    }

	    public Optional<NaveEspacial> updateNave(Long id, NaveEspacial naveEspacial) {
	    	Optional<NaveEspacial> existingNave = naveEspacialRepository.findById(id);
	        
	        if (existingNave.isPresent()) {
	            naveEspacial.setId(id);
	            return Optional.of(naveEspacialRepository.save(naveEspacial));
	        } else {
	            return Optional.empty();
	        }
	    }
	
	@Override
	public void deleteNave(Long id) {
		naveEspacialRepository.deleteById(id);
	}
}
