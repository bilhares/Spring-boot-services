package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;

import com.projeto.model.ProcDiarioOficial;
import com.projeto.repository.EditalRepository;
import com.projeto.repository.ProcDiarioOficialRepository;

@Controller
public class EditalController {

	@Autowired
	EditalRepository editalRepository;
	
	@Autowired
	ProcDiarioOficialRepository procRepository;
	
	@Autowired
	DocumentosController documentosController;

	public void gerarEdital(int tipo, int numEdital) {
		// buscar processos
		List<ProcDiarioOficial> dados = procRepository.findProcessosNaoGerados(tipo);

		// gerar edital
			// gerar docx
		documentosController.gerarDocx(tipo, numEdital, dados);
			// gerar pdf
			// salvar documento na base
			// criar edital/portaria

		// atualizar edital com os ids dos docs
		// atuallizar processos
	}

}
