package br.com.negociacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.negociacoes.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
