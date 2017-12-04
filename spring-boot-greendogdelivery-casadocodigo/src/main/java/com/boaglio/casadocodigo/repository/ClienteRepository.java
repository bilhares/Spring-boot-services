package com.boaglio.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boaglio.casadocodigo.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT * FROM CLIENTE WHERE ENDERECO LIKE %?1%", nativeQuery = true)
	public List<Cliente> findByEndereco(String endereco);

}
