package com.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "portaria_do")
public class Portaria {

	@Id
	@Column(name = "num_portaria")
	private Long nPortaria;

	@Column(name = "data_portaria")
	@Temporal(TemporalType.DATE)
	private Date dataPortaria;

	@Column(name = "aprovado")
	private boolean aprovado;

	@Column(name = "data_publicacao")
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;

	@Column(name = "id_arquivo")
	private int idPortaria;

	@Column(name = "num_diario")
	private Long nDiario;

	@Column(name = "assinado")
	private boolean assinado;

	@Column(name = "id_arquivo_pdf")
	private int idPortariaPdf;

	@Column(name = "ativo")
	private boolean ativo;

	@Column(name = "tipo_portaria")
	private int tipoPortaria;

	public Long getnPortaria() {
		return nPortaria;
	}

	public void setnPortaria(Long nPortaria) {
		this.nPortaria = nPortaria;
	}

	public Date getDataPortaria() {
		return dataPortaria;
	}

	public void setDataPortaria(Date dataPortaria) {
		this.dataPortaria = dataPortaria;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public int getIdPortaria() {
		return idPortaria;
	}

	public void setIdPortaria(int idPortaria) {
		this.idPortaria = idPortaria;
	}

	public Long getnDiario() {
		return nDiario;
	}

	public void setnDiario(Long nDiario) {
		this.nDiario = nDiario;
	}

	public boolean isAssinado() {
		return assinado;
	}

	public void setAssinado(boolean assinado) {
		this.assinado = assinado;
	}

	public int getIdPortariaPdf() {
		return idPortariaPdf;
	}

	public void setIdPortariaPdf(int idPortariaPdf) {
		this.idPortariaPdf = idPortariaPdf;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getTipoPortaria() {
		return tipoPortaria;
	}

	public void setTipoPortaria(int tipoPortaria) {
		this.tipoPortaria = tipoPortaria;
	}

}
