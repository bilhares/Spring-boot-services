package com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import com.projeto.model.ProcDiarioOficial;

public class TestController {

	public List<ProcDiarioOficial> insertFakeData(int total, int proced) {

		List<ProcDiarioOficial> dados = new ArrayList<>();

		if (proced == 57) {

			for (int i = 0; i < total; i++) {
				System.out.println(i + "");
				ProcDiarioOficial processo = new ProcDiarioOficial();
				processo.setCodProcesso(020125 + i);
				processo.setCondutor("TESTE " + i);
				processo.setCnh("11572418" + i + " MS");
				processo.setRegistroPgu("0435288902" + i);
				processo.setTipoProcesso("TIPO DO PROCESSO TIPO DO PROCESSO TIPO DO PROCESSO");
				processo.setnAuto("EEVVMAAN22");
				// if (i % 2 == 0) {
				// processo.setPrazo("02 MESES");
				// }
				processo.setnPontos("007");
				processo.setNumeroProcesso("006155/2015" + i);
				processo.setFundamentoLegal("218 II");
				// encheção de linguiça
				processo.setOrgaoAtuador("290510");
				processo.setPlaca("HTL578" + i);
				processo.setTipificacao("7471 - TRANS VELOCIDADE SUPERIOR A MAXIMA PERMITID 7471 ");

				processo.setTipoProcedimento(proced);
				processo.setCiclo(1);
				processo.setGerado(false);
				processo.setAtivo(true); //
				processo.setIdEdital(null);
				dados.add(processo);
			}

		} else {
			for (int i = 0; i < total; i++) {
				System.out.println(i + "");

				ProcDiarioOficial processo = new ProcDiarioOficial();
				processo.setCodProcesso(020125 + i);
				processo.setCondutor("TESTE " + i);
				processo.setNumeroProcesso("006155/2015" + i);
				processo.setCnh("11572418" + i + " MS");
				processo.setRegistroPgu("0435288902" + i);
				processo.setTipoProcesso("SUSPENSAO DO SEU DIREITO DE CONDUZIR VEICULOS AUTOMOTORES");
				processo.setnAuto("EMV0519170");
				processo.setOrgaoAtuador("290510");
				processo.setPlaca("HTL578" + i);
				processo.setnPontos("0");
				processo.setTipificacao("7471 - TRANS VELOCIDADE SUPERIOR A MAXIMA PERMITID 7471 - ");
				// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //
				// Date
				// date = sdf.parse("27/07/2006"); //

				processo.setTipoProcedimento(proced);

				processo.setCiclo(1);
				processo.setFundamentoLegal("218 III");
				processo.setDataHoraLocal("09/08/1996 - BLABLABLABLABLLABLABLABLABL");
				processo.setGerado(false);
				processo.setAtivo(true); //
				processo.setIdEdital(null);
				dados.add(processo);

			}
		}
		return dados;
	}
}
