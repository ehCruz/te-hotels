package br.fesppr.bsi.topicos.hotelaria.pagamento.model;

import java.time.LocalDate;

public abstract class Cartao extends Pagamento {

	private String numeroCartao;
	private String bandeira;
	private String nomeTitular;
	private LocalDate dataValidade;

	public Cartao(String numeroCartao, String bandeira, String nomeTitular, LocalDate dataValidade) {
		this.numeroCartao = numeroCartao;
		this.bandeira = bandeira;
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

}
