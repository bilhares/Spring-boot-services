package com.boaglio.casadocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boaglio.casadocodigo.domain.Cliente;
import com.boaglio.casadocodigo.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/find/{filtro}", method = RequestMethod.GET)
	List<Cliente> findByFiltro(@PathVariable("filtro") String endereco) {
		return repository.findByEndereco(endereco);
	}

}
