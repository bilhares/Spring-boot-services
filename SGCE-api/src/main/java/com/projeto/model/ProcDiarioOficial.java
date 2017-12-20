package com.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proc_diario_oficial")
public class ProcDiarioOficial {

	@Id
	@Column(name = "id_processo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codigo_processo")
	private int codProcesso;

	@Column(name = "condutor")
	private String condutor;

	@Column(name = "numero_processo")
	private String numeroProcesso;

	@Column(name = "cnh")
	private String cnh;

	@Column(name = "registro_pgu")
	private String registroPgu;

	@Column(name = "tipo_processo")
	private String tipoProcesso;

	@Column(name = "num_auto", columnDefinition = "text")
	private String nAuto;

	@Column(name = "orgao_atuador", columnDefinition = "text")
	private String orgaoAtuador;

	@Column(name = "placa")
	private String placa;

	@Column(name = "num_pontos")
	private String nPontos;

	@Column(name = "tipificacao", columnDefinition = "text")
	private String tipificacao;

	@Column(name = "data_hora_local", columnDefinition = "text")
	private String dataHoraLocal;

	@Column(name = "edital_gerado")
	private boolean gerado;

	@Column(name = "id_edital")
	private Long idEdital;

	@Column(name = "tipo_procedimento")
	private int tipoProcedimento;

	@Column(name = "prazo")
	private String prazo;

	@Column(name = "fundamento_legal")
	private String fundamentoLegal;

	@Column(name = "portaria")
	private Long portaria;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "cod_ciclo")
	private int ciclo;

	@Column(name = "ativo")
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(int codProcesso) {
		this.codProcesso = codProcesso;
	}

	public String getCondutor() {
		return condutor;
	}

	public void setCondutor(String condutor) {
		this.condutor = condutor;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getRegistroPgu() {
		return registroPgu;
	}

	public void setRegistroPgu(String registroPgu) {
		this.registroPgu = registroPgu;
	}

	public String getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(String tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}

	public String getnAuto() {
		return nAuto;
	}

	public void setnAuto(String nAuto) {
		this.nAuto = nAuto;
	}

	public String getOrgaoAtuador() {
		return orgaoAtuador;
	}

	public void setOrgaoAtuador(String orgaoAtuador) {
		this.orgaoAtuador = orgaoAtuador;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getnPontos() {
		return nPontos;
	}

	public void setnPontos(String nPontos) {
		this.nPontos = nPontos;
	}

	public String getTipificacao() {
		return tipificacao;
	}

	public void setTipificacao(String tipificacao) {
		this.tipificacao = tipificacao;
	}

	public String getDataHoraLocal() {
		return dataHoraLocal;
	}

	public void setDataHoraLocal(String dataHoraLocal) {
		this.dataHoraLocal = dataHoraLocal;
	}

	public boolean isGerado() {
		return gerado;
	}

	public void setGerado(boolean gerado) {
		this.gerado = gerado;
	}

	public Long getIdEdital() {
		return idEdital;
	}

	public void setIdEdital(Long idEdital) {
		this.idEdital = idEdital;
	}

	public int getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(int tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getFundamentoLegal() {
		return fundamentoLegal;
	}

	public void setFundamentoLegal(String fundamentoLegal) {
		this.fundamentoLegal = fundamentoLegal;
	}

	public Long getPortaria() {
		return portaria;
	}

	public void setPortaria(Long portaria) {
		this.portaria = portaria;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
