package com.projeto.controller.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projeto.model.Edital;
import com.projeto.repository.EditalRepository;

@Controller
public class EditalUtil {

	@Autowired
	EditalRepository editalRepository;

	public void criarEdital(Edital edital) {

		Edital ed = new Edital();

		ed.setnEdital(edital.getnEdital());
		ed.setDataEdital(new Date());
		ed.setAprovado(false);
		ed.setAssinado(false);
		ed.setTipoEdital(edital.getTipoEdital());
		ed.setIdEdital(edital.getIdEdital());
		ed.setIdEditalPdf(edital.getIdEditalPdf());

		editalRepository.save(ed);

	}

}
