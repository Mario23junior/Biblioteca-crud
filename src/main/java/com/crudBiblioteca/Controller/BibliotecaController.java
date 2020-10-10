package com.crudBiblioteca.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudBiblioteca.Biblioteca.Biblioteca;
import com.crudBiblioteca.Repository.BibliotecaRepository;

@RestController
public class BibliotecaController {
      
	private BibliotecaRepository repository;
	
	public BibliotecaController(BibliotecaRepository bibliotecaRepository) {
		 this.repository = bibliotecaRepository;
 	}
	
	@GetMapping(value = "/list")
	public List<Biblioteca> list() {
		 return repository.findAll();
	}
	
	@GetMapping(path = {"listId/{id}"})
	public ResponseEntity<Biblioteca> findById(@PathVariable long id) {
	   return repository.findById(id)
			  .map(listar -> ResponseEntity.ok().body(listar))
			  .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(value = "/save")
	public Biblioteca create(@RequestBody Biblioteca biblioteca) {
		return repository.save(biblioteca);
	}
	
	@DeleteMapping(path = {"delete/{id}"})
	public ResponseEntity<Object> delete(@PathVariable long id) {
		return repository.findById(id)
				.map(deletarId -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
 }
