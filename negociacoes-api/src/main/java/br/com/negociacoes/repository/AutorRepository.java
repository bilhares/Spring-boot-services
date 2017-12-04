package br.com.negociacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.negociacoes.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
