package br.fesppr.bsi.topicos.hotelaria.model;

import java.time.LocalDate;

import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoProduto;

public class Produto {

	private String nome;
	private LocalDate prazoValidade;
	private Integer qtdEstoque;

	private Servico servico;
	private TipoProduto tipoProduto;

	public Produto(Servico servico, TipoProduto tipoProduto) {
		this.servico = servico;
		this.tipoProduto = tipoProduto;
	}

	public boolean validarQualidade() {
		// TODO validacao qualidade
		return true;
	}

	public void setIndicadorEstoque(Integer qtd) {
		// TODO validacao indicadores
	}

	public void cadastrarProduto() {
		// TODO cadastros
	}

	public void descadastrarProduto() {
		// TODO remocao
	}

	public void solicitarProduto() {
		// TODO solicitacao
	}

	public void devolverProduto() {
		// TODO devolucao
	}

	public void verficarEstoque() {
		// TODO verificacao
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

}
