package com.projeto.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "SELECT * FROM PESSOA WHERE ESTADO LIKE %?1%", nativeQuery = true)
	public List<Pessoa> findByEndereco(String endereco);
}
