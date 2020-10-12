package com.crudBiblioteca.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudBiblioteca.Biblioteca.Usuario;
import com.crudBiblioteca.Repository.RepositoryUsuario;
 
@RestController
@RequestMapping("/salvar/user")
public class UsuarioController {
	
	 public UsuarioController() {
 	}
   
	 private RepositoryUsuario repository;
	
	 public UsuarioController(RepositoryUsuario repositoryUsuario) {
		 this.repository = repositoryUsuario;
	} 
	 
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 public Usuario salvar(@RequestBody Usuario usuario) {
		 return repository.save(usuario);
	 }
} 
