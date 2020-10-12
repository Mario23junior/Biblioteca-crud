package com.crudBiblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudBiblioteca.Biblioteca.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer>{

}
