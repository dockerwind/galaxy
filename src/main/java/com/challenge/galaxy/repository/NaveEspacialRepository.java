package com.challenge.galaxy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.challenge.galaxy.model.NaveEspacial;

@Repository
public interface NaveEspacialRepository extends JpaRepository<NaveEspacial, Long>, PagingAndSortingRepository<NaveEspacial, Long> {

    List<NaveEspacial> findByNombreContainingIgnoreCase(String nombre);
}
