package br.fesppr.bsi.topicos.hotelaria.model;

import java.util.ArrayList;
import java.util.List;

public class Cargo {

	private String nome;

	private List<Servico> servicos = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public void cadastrarCargo(String nome) {
		// TODO cadastro de novo cargo
		this.nome = nome;
	}

	public void descadastrarCargo() {
		// TODO remocao de cargo
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public void removerFuncionario(Funcionario funcionario) {
		funcionarios.remove(funcionario);
	}

	public void adicionarServico(Servico servico) {
		servicos.add(servico);
	}

	public void removerServico(Servico servico) {
		servicos.remove(servico);
	}

	public String getNome() {
		return nome;
	}

	public List<Servico> getServico() {
		return servicos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}
