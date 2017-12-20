package com.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.EditalController;
import com.projeto.controller.TestController;
import com.projeto.model.Edital;
import com.projeto.model.ProcDiarioOficial;
import com.projeto.repository.EditalRepository;
import com.projeto.repository.ProcDiarioOficialRepository;

@RestController
@RequestMapping("/api")
public class EditalService {

	@Autowired
	EditalRepository editalRepository;

	@Autowired
	ProcDiarioOficialRepository procRepository;

	@Autowired
	EditalController controller;

	@PreAuthorize("hasAuthority('ROLE_PESQUISAR') and #oauth2.hasScope('read')")
	@RequestMapping(value = "/editais", method = RequestMethod.GET)
	public List<Edital> listar() {
		return editalRepository.findAll();
	}

	@GetMapping("/{num}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR') and #oauth2.hasScope('read')")
	public ResponseEntity<Edital> buscarPeloCodigo(@PathVariable("num") Long num) {
		Edital edital = editalRepository.findOne(num);
		return edital != null ? ResponseEntity.ok(edital) : ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/processos/{tipo}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR') and #oauth2.hasScope('read')")
	public Page<ProcDiarioOficial> listarProcessos(Pageable pageable, @PathVariable("tipo") int tipo) {
		return procRepository.findByTipo(pageable, tipo);
	}

	@RequestMapping(value = "/processos/id/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR') and #oauth2.hasScope('read')")
	public ProcDiarioOficial buscaPorId(@PathVariable("id") Long id) {
		return procRepository.findOne(id);
	}

	@RequestMapping(value = "/gerar-edital/{tipo}/{num}", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')")
	void insertFakeData(@PathVariable("tipo") int tipo, @PathVariable("num") int numEdital) {
		controller.gerarEdital(tipo, numEdital);
	}

}
