package com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projeto.model.Arquivo;
import com.projeto.repository.ArquivoRepository;

@Controller
public class ArquivoController {

	@Autowired
	ArquivoRepository arquivoRepository;
	
	public int salvarArquvivo(byte[] data) {
		Arquivo arquivo = new Arquivo();
		arquivo.setArquivo(data);
		Arquivo save = arquivoRepository.save(arquivo);
		return save.getId();
		
	}
	
}
