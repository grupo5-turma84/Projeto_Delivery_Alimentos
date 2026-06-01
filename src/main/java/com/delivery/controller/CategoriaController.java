package com.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

import com.delivery.model.Categoria;
import com.delivery.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CategoriaController {
	 @Autowired
	    private CategoriaRepository repository;

	    @GetMapping
	    public ResponseEntity<List<Categoria>> getAll() {
	        return ResponseEntity.ok(repository.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Categoria> getById(@PathVariable Long id) {

	        return repository.findById(id)
	                .map(resposta -> ResponseEntity.ok(resposta))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {

	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(repository.save(categoria));
	    }

	    @PutMapping
	    public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {

	        return ResponseEntity.ok(repository.save(categoria));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {

	        return repository.findById(id)
	                .map(resposta -> {
	                    repository.deleteById(id);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

}
