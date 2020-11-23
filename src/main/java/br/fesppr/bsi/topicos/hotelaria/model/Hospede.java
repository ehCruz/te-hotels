package br.fesppr.bsi.topicos.hotelaria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospede {

	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String telefonePrincipal;
	private String telefoneSecundario;
	private String email;

	private Dependente dependente;
	private List<Reserva> reservas = new ArrayList<>();
	private Endereco endereco;

	public Hospede(Endereco endereco) {
		this.endereco = endereco;
	}

	public void liberarPermissaoDependente(Hospede dependente) {
		dependente.getDependente().setPermissao(true);
	}

	public void removerPermissaoDependente(Hospede dependente) {
		dependente.getDependente().setPermissao(false);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco != null) {
			this.endereco = endereco;
		}
	}

}