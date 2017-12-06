package br.com.negociacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.negociacoes.model.Livro;
import br.com.negociacoes.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroControlller {
	@Autowired
	LivroRepository repository;

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<?> salvarAutor(@RequestBody Livro livro) {
		repository.save(livro);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	List<Livro> findAll() {
		return repository.findAll();
	}

}
