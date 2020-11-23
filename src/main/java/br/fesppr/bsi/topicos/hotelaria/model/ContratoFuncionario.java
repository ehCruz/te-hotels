package br.fesppr.bsi.topicos.hotelaria.model;

import java.time.LocalDate;

public class ContratoFuncionario {

	private LocalDate dataContratacao;
	private LocalDate dataDemissao;
	private String motivoDemissao;

	private Funcionario funcionario;

	public void finalizarContrato() {
		this.dataDemissao = LocalDate.now();
		this.motivoDemissao = "Contrato finalizado";
	}

	public void demitir(String motivo, LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
		this.motivoDemissao = motivo;
	}

	public String getMotivoDemissao() {
		return motivoDemissao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

}
