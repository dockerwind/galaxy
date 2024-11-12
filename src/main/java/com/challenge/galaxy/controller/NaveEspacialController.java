package com.challenge.galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.galaxy.exception.RecursoNoEncontradoException;
import com.challenge.galaxy.model.NaveEspacial;
import com.challenge.galaxy.service.NaveEspacialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/naves")
@Tag(name = "Naves Espaciales", description = "Operaciones para gestionar las naves espaciales")
public class NaveEspacialController {

	private static final String NAVE_NO_ENCONTRADA = "Nave espacial no encontrada con ID: ";
    
	@Autowired
    private NaveEspacialService naveEspacialService;

    
    @Operation(summary = "Obtener todas las naves espaciales con paginación")
    @GetMapping
    public ResponseEntity<Page<NaveEspacial>> getAllNaves(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(naveEspacialService.getAllNaves(page, size), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una nave espacial por ID")
    @GetMapping("/{id}")
    public ResponseEntity<NaveEspacial> getNaveById(@PathVariable Long id) {
    	NaveEspacial nave = naveEspacialService.getNaveById(id)
    			.orElseThrow(() -> new RecursoNoEncontradoException(NAVE_NO_ENCONTRADA + id));
    	return ResponseEntity.ok(nave);
    }

    @Operation(summary = "Buscar naves espaciales por nombre")
    @GetMapping("/search")
    public ResponseEntity<List<NaveEspacial>> getNavesByNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(naveEspacialService.getNavesByNombre(nombre), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva nave espacial")
    @PostMapping
    public ResponseEntity<NaveEspacial> createNave(@RequestBody NaveEspacial naveEspacial) {
        return new ResponseEntity<>(naveEspacialService.createNave(naveEspacial), HttpStatus.CREATED);
    }
   
    @Operation(summary = "Actualizar una nave espacial por ID")
    @PutMapping("/{id}")
    public ResponseEntity<NaveEspacial> updateNave(
            @Parameter(description = "ID de la nave espacial") @PathVariable Long id,
            @RequestBody NaveEspacial naveEspacial) {
    	  NaveEspacial updatedNave = naveEspacialService.updateNave(id, naveEspacial)
                  .orElseThrow(() -> new RecursoNoEncontradoException(NAVE_NO_ENCONTRADA + id));
          return ResponseEntity.ok(updatedNave);
    }
    
    @Operation(summary = "Eliminar una nave espacial por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNave(@PathVariable Long id) {
    	 naveEspacialService.getNaveById(id)
         .orElseThrow(() -> new RecursoNoEncontradoException(NAVE_NO_ENCONTRADA + id));
    	 naveEspacialService.deleteNave(id);
    	 return ResponseEntity.noContent().build();
    }
}
