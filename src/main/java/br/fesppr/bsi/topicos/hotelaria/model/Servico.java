package br.fesppr.bsi.topicos.hotelaria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoServico;

public class Servico {

	private Long codigo;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFinalizacao;

	private List<Produto> produtos = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();

	private Quarto quarto;
	private Cargo cargo;
	private TipoServico tipoServico;

	public Servico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public void cadastrarServicoDeQuarto() {
		// TODO cadastro
	}

	public void solicitarServicoDeQuarto() {
		// TODO solicitacao
	}

	public void finalizarServicoDeQuarto() {
		// TODO finalizacao
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

}
