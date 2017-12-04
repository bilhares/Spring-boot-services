package br.com.negociacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.negociacoes.model.Autor;
import br.com.negociacoes.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository repository;
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> salvarAutor(@RequestBody Autor autor) {
		
		if(repository.save(autor) != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@RequestMapping(method = RequestMethod.GET)
	List<Autor> findAll(){
		return repository.findAll();
	}
}
