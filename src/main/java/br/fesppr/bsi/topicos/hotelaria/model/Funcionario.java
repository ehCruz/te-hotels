package br.fesppr.bsi.topicos.hotelaria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {

	private String nome;
	private LocalDate dataNascimento;
	private Integer carteiraTrabalho;
	private Integer contaSalario;

	private Hotel hotel;
	private Endereco endereco;
	private List<Transferencia> transferencias = new ArrayList<>();
	private List<ContratoFuncionario> contratos = new ArrayList<>();
	private List<Cargo> cargos = new ArrayList<>();
	private List<Servico> servicos = new ArrayList<>();

	public Funcionario(Endereco endereco, Cargo cargo, ContratoFuncionario contrato) {
		contrato.setFuncionario(this);
		this.contratos.add(contrato);
		this.endereco = endereco;
		cargo.adicionarFuncionario(this);
		this.cargos.add(cargo);
	}

	public List<Transferencia> solicitarHistoricoFuncionario() {
		return this.transferencias;
	}

	public void realizarTransferencia(Hotel hotel) {
		if (hotel != null) {
			this.hotel = hotel;
			Transferencia transferencia = new Transferencia(this, this.hotel);
			this.transferencias.add(transferencia);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(Integer carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Integer getContaSalario() {
		return contaSalario;
	}

	public void setContaSalario(Integer contaSalario) {
		this.contaSalario = contaSalario;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ContratoFuncionario> getContratos() {
		return contratos;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

}
