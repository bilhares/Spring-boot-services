package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
