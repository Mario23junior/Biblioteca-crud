package com.crudBiblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudBiblioteca.Biblioteca.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{

}
