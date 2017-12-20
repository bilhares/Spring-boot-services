package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projeto.controller.util.DocumentosUtil;
import com.projeto.model.ProcDiarioOficial;

@Controller
public class DocumentosController {

	@Autowired
	DocumentosUtil documentosUtil;

	public void gerarDocx(int tipoEdital, int numEdital, List<ProcDiarioOficial> processos) {

		switch (tipoEdital) {
		case 5:
			System.out.println("15 dias");
			break;
		case 57:
			System.out.println("portaria");
			documentosUtil.gerarDocxPenalidades(processos, numEdital);
			break;
		default:
			break;
		}
	}

}
