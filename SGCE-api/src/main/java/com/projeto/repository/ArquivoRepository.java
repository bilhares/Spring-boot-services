package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

}
