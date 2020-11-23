package br.fesppr.bsi.topicos.hotelaria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transferencia {

	private LocalDate inicio;
	private LocalDate fim;

	private List<Hotel> hoteis = new ArrayList<>();
	private Funcionario funcionario;
	
	public Transferencia(Funcionario funcionario, Hotel hotel) {
		this.hoteis.add(hotel);
		this.funcionario = funcionario;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

}
