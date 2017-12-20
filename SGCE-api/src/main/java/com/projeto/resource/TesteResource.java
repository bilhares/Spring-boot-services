package com.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.TestController;
import com.projeto.model.ProcDiarioOficial;
import com.projeto.repository.EditalRepository;
import com.projeto.repository.ProcDiarioOficialRepository;

@RestController
@RequestMapping("/teste")
public class TesteResource {

	@Autowired
	EditalRepository editalRepository;

	@Autowired
	ProcDiarioOficialRepository procRepository;

	@RequestMapping(value = "/insert-fake/{quantidade}/{tipo}", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')")
	void insertFakeData(@PathVariable("quantidade") int qtd, @PathVariable("tipo") int tipo) {
		TestController cont = new TestController();
		List<ProcDiarioOficial> dados = cont.insertFakeData(qtd, tipo);
		procRepository.save(dados);
	}

}
