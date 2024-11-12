package com.challenge.galaxy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.challenge.galaxy.model.NaveEspacial;

public interface NaveEspacialService {
	Page<NaveEspacial> getAllNaves(int page, int size);
	Optional<NaveEspacial> getNaveById(Long id);
	List<NaveEspacial> getNavesByNombre(String nombre);
	NaveEspacial createNave(NaveEspacial naveEspacial);
	Optional<NaveEspacial> updateNave(Long id, NaveEspacial naveEspacial);
	void deleteNave(Long id);
}
